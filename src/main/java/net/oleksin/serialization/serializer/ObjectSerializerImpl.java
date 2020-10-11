package net.oleksin.serialization.serializer;

import net.oleksin.serialization.ObjectSerializer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectSerializerImpl implements ObjectSerializer {
  
  @Override
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    out.writeUTF(obj.getClass().toString());
  }
  
  @Override
  public Object deserialize(DataInputStream in) throws IOException {
    try {
      Class cl = Class.forName(in.readUTF());
      Object obj = cl.newInstance();
      return obj;
    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
      e.printStackTrace();
    }
    return null;
  }
}
