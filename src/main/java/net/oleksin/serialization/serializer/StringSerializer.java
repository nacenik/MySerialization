package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class StringSerializer implements Serializer {
  
  @Override
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    String str = (String) obj;
    out.writeInt(str.length());
    out.writeUTF(str);
  }
  
  @Override
  public String deserialize(DataInputStream in) throws IOException {
    int strSize = in.readInt();
    String str = in.readUTF();
    return str.length() == strSize ? str : null;
  }
}
