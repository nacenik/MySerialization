package net.oleksin.serialization;

import net.oleksin.serialization.deserializer.*;

import java.util.*;

public class CodeDeserializationFactory {
    private Map<Class<?>, Deserializer> deserializerMap;
    
    public CodeDeserializationFactory() {
      deserializerMap = new HashMap<>();
      deserializerMap.put(Integer.class, new IntegerDeserializer());
      deserializerMap.put(Byte.class, new ByteDeserializer());
      deserializerMap.put(Short.class, new ShortDeserializer());
      deserializerMap.put(Long.class, new LongDeserializer());
      deserializerMap.put(Float.class, new FloatDeserializer());
      deserializerMap.put(Double.class, new DoubleDeserializer());
      deserializerMap.put(Character.class, new CharDeserializer());
      deserializerMap.put(String.class, new StringDeserializer());
      deserializerMap.put(Boolean.class, new BooleanDeserializer());
      deserializerMap.put(List.class, new ListDeserializer());
      deserializerMap.put(ArrayList.class, new ListDeserializer());
      deserializerMap.put(LinkedList.class, new ListDeserializer());
      deserializerMap.put(Map.class, new MapDeserializer());
      deserializerMap.put(HashMap.class, new MapDeserializer());
    }
    
    public Deserializer get(Class<?> klass) {
      return deserializerMap.get(klass);
    }
}
