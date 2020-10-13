package net.oleksin.serialization;

import java.util.Map;

public class Address {
  
  private String city;
  
  private String street;
  
  private Integer building;
  
  private Map<Long, Integer> zipCodes;
  
  public Address() {
  }
  
  public Address(String city, String street, Integer building, Map<Long, Integer> zipCodes) {
    this.city = city;
    this.street = street;
    this.building = building;
    this.zipCodes = zipCodes;
  }
  
  @Override
  public String toString() {
    return "Address{" +
            "city='" + city + '\'' +
            ", street='" + street + '\'' +
            ", building=" + building +
            ", zipCodes=" + zipCodes +
            '}';
  }
}
