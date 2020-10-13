package net.oleksin.serialization;

import java.util.HashMap;
import java.util.Map;

public class SerializingNamesPool {
  private final Map<String, Integer> serializeTypesMap;
  private int typeId = 0;
  
  public SerializingNamesPool() {
    this.serializeTypesMap = new HashMap<>();
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
}
