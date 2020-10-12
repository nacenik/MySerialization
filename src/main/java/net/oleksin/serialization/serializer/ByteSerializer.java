package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ByteSerializer implements Serializer {

  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Byte aByte = (Byte) obj;
    out.writeByte(aByte);
  }
  
  public Byte deserialize(DataInputStream in) throws IOException {
    return in.readByte();
  }
  
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException, IllegalAccessException {
    serializingContext.writeByte((Byte) obj);
  }
}