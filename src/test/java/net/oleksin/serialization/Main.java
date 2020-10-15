package net.oleksin.serialization;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    List<Address> addresses = new ArrayList();
    Map<Long, Integer> map = new HashMap<>();
    map.put(10L, 100);
    addresses.add(new Address("Dnipro", "Slavy", 10, map, new Date()));
    User user = new User("Terminator", LocalDateTime.now(), 5, addresses);
    User user2 = new User("Nikita", LocalDateTime.now(), 10, addresses);
    List<User> users = new ArrayList();
    users.add(user);
    users.add(user2);
    
    LocalTime javaStart = LocalTime.now();
    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("JavaSerialization"));
    outputStream.writeObject(users);
    outputStream.close();
    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("JavaSerialization"));
    List <?> listJava = (List<?>) inputStream.readObject();
    inputStream.close();
    System.out.println("java Serializer: " + ChronoUnit.MILLIS.between(javaStart, LocalTime.now()));
    System.out.println(listJava);
    
    LocalTime myStart = LocalTime.now();
    MySerialization serialization = new MySerializationImpl();
    serialization.serializeObject(users, "MySerialization");
    List<?> list = (List<?>) serialization.deserializeObject("MySerialization");
    System.out.println("Mu Serialize: " + ChronoUnit.MILLIS.between(myStart, LocalTime.now()));
    System.out.println(list);
  }
}
