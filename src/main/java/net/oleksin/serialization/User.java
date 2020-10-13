package net.oleksin.serialization;

import java.time.LocalDateTime;
import java.util.List;

public class User {
  
  private String name;
  
  private LocalDateTime birthDate;
  
  private Integer age;
  
  private List<Address> addresses;
  
  public User() {
  }
  
  public User(String name, LocalDateTime birthDate, Integer age, List<Address> addresses) {
    this.name = name;
    this.birthDate = birthDate;
    this.age = age;
    this.addresses = addresses;
  }
  
  @Override
  public String toString() {
    return "User{" +
            "name='" + name + '\'' +
            ", birthDate=" + birthDate +
            ", age=" + age +
            ", addresses=" + addresses +
            '}';
  }
}
