package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DoubleSerializer implements Serializer {
  
  public void serialize(DataOutputStream out, Double aDouble) throws IOException {
    out.writeDouble(aDouble);
  }
  
  public Double deserialize(DataInputStream in) throws IOException {
    return in.readDouble();
  }
  
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException, IllegalAccessException {
    serializingContext.writeDouble((Double) obj);
  }
}