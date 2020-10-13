package net.oleksin.serialization;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
    List<Address> addresses = new ArrayList();
    Map<Long, Integer> map = new HashMap<>();
    map.put(10L, 100);
    addresses.add(new Address("Dnipro", "Slavy", 10, map));
    User user = new User("Terminator", LocalDateTime.now(), 5, addresses);
    List<User> users = new ArrayList();
    users.add(user);
    MySerialization serialization = new MySerializationImpl();
    serialization.serializeObject(user, "path");
    List list = Collections.singletonList(serialization.deserializeObject("path"));
    System.out.println(list);
  }
}
