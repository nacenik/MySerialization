package net.oleksin.serialization.serializer;

import net.oleksin.serialization.ObjectSerializer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ByteSerializer implements ObjectSerializer {
  @Override
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Byte aByte = (Byte) obj;
    out.writeByte(aByte);
  }
  
  @Override
  public Byte deserialize(DataInputStream in) throws IOException {
    return in.readByte();
  }
}
