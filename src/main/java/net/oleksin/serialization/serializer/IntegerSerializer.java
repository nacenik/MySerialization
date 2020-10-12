package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class IntegerSerializer implements Serializer {
  
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Integer integer = (Integer) obj;
    out.writeInt(integer);
  }
  
  public Integer deserialize(DataInputStream in) throws IOException {
    return in.readInt();
  }
  
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException, IllegalAccessException {
    serializingContext.writeInt((Integer) obj);
  }
}