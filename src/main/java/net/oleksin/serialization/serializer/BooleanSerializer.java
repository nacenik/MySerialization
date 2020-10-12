package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class BooleanSerializer implements Serializer {

  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Boolean aBoolean = (Boolean) obj;
    out.writeBoolean(aBoolean);
  }
  
  public Boolean deserialize(DataInputStream in) throws IOException {
    return in.readBoolean();
  }
  
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException, IllegalAccessException {
    serializingContext.writeBoolean((Boolean) obj);
  }
}