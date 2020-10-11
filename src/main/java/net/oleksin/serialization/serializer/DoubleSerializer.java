package net.oleksin.serialization.serializer;

import net.oleksin.serialization.ObjectSerializer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DoubleSerializer implements ObjectSerializer {
  
  @Override
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Double aDouble = (Double) obj;
    out.writeDouble(aDouble);
  }
  
  @Override
  public Double deserialize(DataInputStream in) throws IOException {
    return in.readDouble();
  }
}
