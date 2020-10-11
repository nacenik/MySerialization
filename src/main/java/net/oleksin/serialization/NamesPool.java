package net.oleksin.serialization;

import java.util.HashMap;
import java.util.Map;

public class NamesPool {
  private final Map<String, Integer> serializeTypesMap;
  private final Map<Integer, String> deserializeTypesMap;
  private int typeId = 0;
  
  public NamesPool() {
    this.serializeTypesMap = new HashMap<>();
    this.deserializeTypesMap = new HashMap<>();
  }
  
  public Integer getTypeForSerialize(String name) {
    if (serializeTypesMap.containsKey(name)) {
      return serializeTypesMap.get(name);
    }
    serializeTypesMap.put(name, typeId);
    return typeId++;
  }
  
  public Map<String, Integer> getSerializeTypesMap() {
    return serializeTypesMap;
  }
  
  public String getClassForDeserialize(Integer integer) {
    return deserializeTypesMap.get(integer);
  }
  
  public String put(Integer integer, String name) {
    return deserializeTypesMap.put(integer, name);
  }
  
  public Map<Integer, String> getDeserializeTypesMap() {
    return deserializeTypesMap;
  }
}
