package net.oleksin.serialization;

import net.oleksin.serialization.serializer.*;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.*;

/**
 * First 7 bytes - NIKITOS
 * long - Names table offset
 * ****Object information
 * Int - Class ID
 * int - field ID
 * Depends on field class:
 *     String: int - String size; String utf-8 bytes
 *     Core classes: field data
 *     Other: Object information
 * Names table
 */
public class MySerializationImpl implements MySerialization {
  
  private final String header = "NIKITOS";
  private final int objectNumberForSerialize = 0x200;
  private final int mapNumberForSerialize = 0x199;
  private final int objectsArraySerializer = 0x198;
  private long offset = 0;
  private Map<Class<?>, Integer> typeMap;
  private NamesPool namesPool;
  private Map<Integer, ObjectSerializer> serializerMap;
  
  public MySerializationImpl() {
    typeMap = new HashMap<>();
    typeMap.put(Byte.class, 0x00);
    typeMap.put(Short.class, 0x01);
    typeMap.put(Integer.class, 0x02);
    typeMap.put(Long.class, 0x03);
    typeMap.put(Float.class, 0x04);
    typeMap.put(Double.class, 0x05);
    typeMap.put(Character.class, 0x06);
    typeMap.put(Boolean.class, 0x07);
    typeMap.put(String.class, 0x08);
    typeMap.put(LocalDateTime.class, 0x09);
    typeMap.put(Arrays.class, objectsArraySerializer);
    typeMap.put(Map.class, mapNumberForSerialize);
    
    serializerMap = new HashMap<>();
    serializerMap.put(0x00, new ByteSerializer());
    serializerMap.put(0x01, new ShortSerializer());
    serializerMap.put(0x02, new IntegerSerializer());
    serializerMap.put(0x03, new LongSerializer());
    serializerMap.put(0x04, new FloatSerializer());
    serializerMap.put(0x05, new DoubleSerializer());
    serializerMap.put(0x06, new CharSerializer());
    serializerMap.put(0x07, new BooleanSerializer());
    serializerMap.put(0x08, new StringSerializer());
    serializerMap.put(0x09, new LocalDateTimeSerializer());
    serializerMap.put(objectsArraySerializer, new ArraySerializer());
    serializerMap.put(mapNumberForSerialize, new MapSerializer());
    serializerMap.put(objectNumberForSerialize, new ObjectSerializerImpl());
    namesPool = new NamesPool();
  }
  
  @Override
  public void serializeObject(Object obj, String name) throws IOException {
    DataOutputStream oout = new DataOutputStream(new FileOutputStream(name));
    oout.write(header.getBytes());
    oout.writeLong(offset);
    serialize(obj, oout);
    offset = oout.size() - header.length();
    
    writeNamesPool(name);
    
    serializerMap.get(mapNumberForSerialize).serialize(oout, namesPool.getSerializeTypesMap());
  }
  
  private void writeNamesPool(String name) throws IOException {
    ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
    buffer.putLong(offset);
    try (RandomAccessFile raf = new RandomAccessFile(name, "rw")) {
      raf.seek(header.length());
      raf.write(buffer.array());
    }
  }
  
  private void serialize(Object obj, DataOutputStream out) throws IOException {
    out.writeInt(namesPool.getTypeForSerialize(obj.getClass().getName()));
    serializeField(obj, out);
  }
  
  private void serializeField(Object obj, DataOutputStream out) {
    for (Field field : obj.getClass().getDeclaredFields()) {
      field.setAccessible(true);
      try {
        if (field.get(obj).getClass().isArray()) {
          out.writeInt(objectsArraySerializer);
          out.writeInt(namesPool.getTypeForSerialize(field.get(obj).getClass().getName()));
          serializerMap.get(objectsArraySerializer).serialize(out, field.get(obj));
        } else {
          int type = typeMap.getOrDefault(field.get(obj).getClass(), objectNumberForSerialize);
          out.writeInt(type);
          out.writeInt(namesPool.getTypeForSerialize(field.get(obj).getClass().getName()));
          if (type == objectNumberForSerialize) {
            serialize(field.get(obj), out);
          } else {
            serializerMap.get(type).serialize(out, field.get(obj));
          }
        }
      } catch (IllegalAccessException | IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  @Override
  public Object deserializeObject(String name) throws IOException {
    DataInputStream in = new DataInputStream(new FileInputStream(name));
    byte[] bytes = new byte[header.length()];
    in.read(bytes);
    String str = new String(bytes);
    if (header.equals(str)) {
      offset = in.readLong();
      readNamesPool(name);
      try {
        return deserialize(in);
      } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
        e.printStackTrace();
      }
    } else {
      throw new NotSerializableException();
    }
    return null;
  }
  
  private Object deserialize(DataInputStream in) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
    int nameType = in.readInt();
    Object obj =  deserializeClass(in, nameType);
    return obj;
  }
  
  private Object deserializeClass(DataInputStream in, int nameType) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
    Class aClass = Class.forName(namesPool.getClassForDeserialize(nameType));
    Object obj = aClass.newInstance();
    deserializeField(in, obj);
    return obj;
  }
  
  private void deserializeField(DataInputStream in, Object obj) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
    for (Field field : obj.getClass().getDeclaredFields()) {
      field.setAccessible(true);
      int type = in.readInt();
      in.readInt();
      if (type == objectNumberForSerialize) {
        int typeName = in.readInt();
        field.set(obj, deserializeClass(in, typeName));
      }else {
        field.set(obj,
                serializerMap.get(type).deserialize(in));
      }
    }
  }
  
  private void readNamesPool(String name) throws IOException {
    try (RandomAccessFile raf = new RandomAccessFile(name, "rw")) {
      raf.seek(offset + header.length());
      raf.readUTF();
      int size = raf.readInt();
      namesPool = new NamesPool();
      for (int i = 0; i < size; i++) {
        String s = raf.readUTF();
        namesPool.put(Integer.valueOf(raf.readUTF()), s);
      }
    }
  }
}
