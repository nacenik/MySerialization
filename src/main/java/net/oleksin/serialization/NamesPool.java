package net.oleksin.serialization;

import java.util.HashMap;
import java.util.Map;

public class NamesPool {
  private final Map<String, Integer> typesMap;
  private int typeId = 0;
  
  public NamesPool() {
    this.typesMap = new HashMap<>();
  }
  
  public Integer getTypeFor(String name) {
    return typesMap.getOrDefault(name, addNewName(name));
  }
  
  private Integer addNewName(String name) {
    typesMap.put(name, typeId);
    return typeId++;
  }
  
  public Map<String, Integer> getTypesMap() {
    return typesMap;
  }
}
