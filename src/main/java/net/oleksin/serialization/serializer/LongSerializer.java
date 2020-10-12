package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class LongSerializer implements Serializer {

  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Long aLong = (Long) obj;
    out.writeLong(aLong);
  }
  
  
  public Long deserialize(DataInputStream in) throws IOException {
    return in.readLong();
  }
  
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException {
    serializingContext.writeInt((Integer) obj);
  }
}