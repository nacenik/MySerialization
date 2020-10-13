package net.oleksin.serialization;

import net.oleksin.serialization.serializer.ArraySerializer;
import net.oleksin.serialization.serializer.ObjectSerializer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class SerializingContext {
  
  private final DataOutputStream dataOutputStream;
  private final CoreSerializerFactory coreSerializerFactory;
  private final Serializer arraySerializer;
  private final Serializer objectSerializer;
  private final SerializingNamesPool serializingNamesPool;
  
  public SerializingContext(DataOutputStream dataOutputStream) {
    this.dataOutputStream = dataOutputStream;
    coreSerializerFactory = new CoreSerializerFactory();
    arraySerializer = new ArraySerializer();
    objectSerializer = new ObjectSerializer();
    serializingNamesPool = new SerializingNamesPool();
  }
  
  public void writeObject(Object obj) throws IOException, IllegalAccessException {
    Class klass = obj.getClass();
    dataOutputStream.writeInt(serializingNamesPool.getTypeForSerialize(klass.getName()));
    if (klass.isArray()) {
      arraySerializer.serialize(this, obj);
      return;
    }
    
    Serializer serializer = coreSerializerFactory.get(klass);
    if (serializer != null) {
      serializer.serialize(this, obj);
      return;
    }
    
    objectSerializer.serialize(this, obj);
  }
  
  public void writeInt(Integer integer) throws IOException {
    dataOutputStream.writeInt(integer);
  }
  
  public void writeByte(Byte aByte) throws IOException {
    dataOutputStream.writeByte(aByte);
  }
  
  public void writeShort(Short aShort) throws IOException {
    dataOutputStream.writeShort(aShort);
  }
  
  public void writeLong(Long aLong) throws IOException {
    dataOutputStream.writeLong(aLong);
  }
  
  public void writeFloat(Float aFloat) throws IOException {
    dataOutputStream.writeFloat(aFloat);
  }
  
  public void writeDouble(Double aDouble) throws IOException {
    dataOutputStream.writeDouble(aDouble);
  }
  
  public void writeChar(Character aChar) throws IOException {
    dataOutputStream.writeChar(aChar);
  }
  
  public void writeBoolean(Boolean aBoolean) throws IOException {
    dataOutputStream.writeBoolean(aBoolean);
  }
  
  public void writeUTF(String str) throws IOException {
    dataOutputStream.writeUTF(str);
  }
  
  public void writeFiledName(String name) throws IOException {
    int filedName = serializingNamesPool.getTypeForSerialize(name);
    dataOutputStream.writeInt(filedName);
  }
  
  public void writeNamesPool() throws IOException {
    Map map = serializingNamesPool.getSerializeTypesMap();
    dataOutputStream.writeInt(map.size());
    Set keySet = map.keySet();
    for (Object o : keySet) {
      dataOutputStream.writeUTF(o.toString());
      dataOutputStream.writeUTF(map.get(o).toString());
    }
  }
}
