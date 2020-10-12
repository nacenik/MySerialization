package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ShortSerializer implements Serializer {
  
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Short aShort = (Short) obj;
    out.writeShort(aShort);
  }

  public Short deserialize(DataInputStream in) throws IOException {
    return in.readShort();
  }
  
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException {
    serializingContext.writeShort((Short) obj);
  }
}