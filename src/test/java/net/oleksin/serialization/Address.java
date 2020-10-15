package net.oleksin.serialization;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class Address implements Serializable {
  
  private String city;
  
  private String street;
  
  private Integer building;
  
  private Map<Long, Integer> zipCodes;
  
  private Date date;
  
  public Address() {
  }
  
  public Address(String city, String street, Integer building, Map<Long, Integer> zipCodes, Date date) {
    this.city = city;
    this.street = street;
    this.building = building;
    this.zipCodes = zipCodes;
    this.date = date;
  }
  
  @Override
  public String toString() {
    return "Address{" +
            "city='" + city + '\'' +
            ", street='" + street + '\'' +
            ", building=" + building +
            ", zipCodes=" + zipCodes +
            ", date=" + date +
            '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Address address = (Address) o;
    return Objects.equals(city, address.city) &&
            Objects.equals(street, address.street) &&
            Objects.equals(building, address.building) &&
            Objects.equals(zipCodes, address.zipCodes);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(city, street, building, zipCodes);
  }
}
