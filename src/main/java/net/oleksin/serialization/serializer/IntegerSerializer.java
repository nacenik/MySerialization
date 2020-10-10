package net.oleksin.serialization.serializer;

import net.oleksin.serialization.ObjectSerializer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class IntegerSerializer implements ObjectSerializer {
  
  @Override
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Integer integer = (Integer) obj;
    out.writeInt(integer);
  }
  
  @Override
  public Integer deserialize(DataInputStream in) throws IOException {
    return in.readInt();
  }
}
