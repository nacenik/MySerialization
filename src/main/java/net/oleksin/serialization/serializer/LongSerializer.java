package net.oleksin.serialization.serializer;

import net.oleksin.serialization.ObjectSerializer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class LongSerializer implements ObjectSerializer {
  @Override
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Long aLong = (Long) obj;
    out.writeLong(aLong);
  }
  
  @Override
  public Long deserialize(DataInputStream in) throws IOException {
    return in.readLong();
  }
}
