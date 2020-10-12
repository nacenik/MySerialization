package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class FloatSerializer implements Serializer {
  
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Float aFloat = (Float) obj;
    out.writeFloat(aFloat);
  }

  public Float deserialize(DataInputStream in) throws IOException {
    return in.readFloat();
  }
  
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException, IllegalAccessException {
    serializingContext.writeFloat((Float) obj);
  }
}