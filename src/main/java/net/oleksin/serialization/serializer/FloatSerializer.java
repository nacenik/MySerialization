package net.oleksin.serialization.serializer;

import net.oleksin.serialization.ObjectSerializer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class FloatSerializer implements ObjectSerializer {
  
  @Override
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Float aFloat = (Float) obj;
    out.writeFloat(aFloat);
  }
  
  @Override
  public Float deserialize(DataInputStream in) throws IOException {
    return in.readFloat();
  }
}
