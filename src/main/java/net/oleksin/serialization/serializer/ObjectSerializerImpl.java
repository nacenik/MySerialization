package net.oleksin.serialization.serializer;

import net.oleksin.serialization.ObjectSerializer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectSerializerImpl implements ObjectSerializer {
  
  @Override
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    out.write(obj.getClass().toString().getBytes());
  }
  
  @Override
  public Object deserialize(DataInputStream in) throws IOException {
    return in.read();
  }
}
