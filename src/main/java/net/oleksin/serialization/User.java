package net.oleksin.serialization;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(name, user.name) &&
            Objects.equals(birthDate, user.birthDate) &&
            Objects.equals(age, user.age) &&
            Objects.equals(addresses, user.addresses);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(name, birthDate, age, addresses);
  }
}
