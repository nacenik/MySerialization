package net.oleksin.serialization.serializer;

import net.oleksin.serialization.ObjectSerializer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ShortSerializer implements ObjectSerializer {
  
  @Override
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Short aShort = (Short) obj;
    out.writeShort(aShort);
  }
  
  @Override
  public Short deserialize(DataInputStream in) throws IOException {
    return in.readShort();
  }
}
