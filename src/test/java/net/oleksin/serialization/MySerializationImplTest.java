package net.oleksin.serialization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MySerializationImplTest {
  
  private String fileName = "path";
  private List<Address> addresses;
  private Map<Long, Integer> map;
  private List<User> users;
  private User user;
  private MySerializationImpl mySerialization;
  
  @BeforeEach
  void setUp() {
    addresses = new ArrayList();
    map = new HashMap<>();
    map.put(10L, 100);
    addresses.add(new Address("Dnipro", "Slavy", 10, map));
    user = new User("Terminator", LocalDateTime.now(), 5, addresses);
    users = new ArrayList();
    users.add(user);
    mySerialization = new MySerializationImpl();
  }
  
  @Test
  void shouldSerializeAndDeserializeObject() throws IOException {
    mySerialization.serializeObject(users, fileName);
    List<?> list = (List<?>) mySerialization.deserializeObject(fileName);
    assertEquals(users, list);
    assertEquals(user, list.get(0));
  }
  
}