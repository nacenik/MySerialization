package net.oleksin.serialization;

import net.oleksin.serialization.serializer.*;

import java.time.LocalDateTime;
import java.util.*;

public class CoreSerializerFactory {
  private Map<Class<?>, Serializer> serializerMap;
  
  public CoreSerializerFactory() {
    serializerMap = new HashMap<>();
    serializerMap.put(Integer.class, new IntegerSerializer());
    serializerMap.put(Byte.class, new ByteSerializer());
    serializerMap.put(Short.class, new ShortSerializer());
    serializerMap.put(Long.class, new LongSerializer());
    serializerMap.put(Float.class, new FloatSerializer());
    serializerMap.put(Double.class, new DoubleSerializer());
    serializerMap.put(Character.class, new CharSerializer());
    serializerMap.put(String.class, new StringSerializer());
    serializerMap.put(Boolean.class, new BooleanSerializer());
    serializerMap.put(List.class, new ListSerializer());
    serializerMap.put(LocalDateTime.class, new LocalDateTimeSerializer());
    serializerMap.put(ArrayList.class, new ListSerializer());
    serializerMap.put(LinkedList.class, new ListSerializer());
    serializerMap.put(Map.class, new MapSerializer());
    serializerMap.put(HashMap.class, new MapSerializer());
    
  }
  
  public Serializer get(Class<?> klass) {
    return serializerMap.get(klass);
  }
}