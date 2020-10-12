package net.oleksin.serialization.serializer;

import net.oleksin.serialization.ObjectSerializer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class BooleanSerializer implements ObjectSerializer {
  
  @Override
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Boolean aBoolean = (Boolean) obj;
    out.writeBoolean(aBoolean);
  }
  
  @Override
  public Boolean deserialize(DataInputStream in) throws IOException {
    return in.readBoolean();
  }
}
