package net.oleksin.serialization;

import java.util.HashMap;
import java.util.Map;

public class DeserializingNamesPool {
  private final Map<Integer, String> deserializeTypesMap;
  
  public DeserializingNamesPool() {
    deserializeTypesMap = new HashMap<>();
  }
  
  public String getClassForDeserialize(Integer integer) {
    return deserializeTypesMap.get(integer);
  }
  
  public String put(Integer integer, String name) {
    return deserializeTypesMap.put(integer, name);
  }
}
