package net.oleksin.serialization.serializer;

import net.oleksin.serialization.ObjectSerializer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CharSerializer implements ObjectSerializer {
  @Override
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Character character = (Character) obj;
    out.writeChar(character);
  }
  
  @Override
  public Character deserialize(DataInputStream in) throws IOException {
    return in.readChar();
  }
}
