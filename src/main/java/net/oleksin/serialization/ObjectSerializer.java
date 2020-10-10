package net.oleksin.serialization;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface ObjectSerializer<T> {
  
  void serialize(DataOutputStream out, T obj) throws IOException;
  
  T deserialize(DataInputStream in) throws IOException;
}
