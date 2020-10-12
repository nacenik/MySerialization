package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class CharSerializer implements Serializer {
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Character character = (Character) obj;
    out.writeChar(character);
  }
  
  public Character deserialize(DataInputStream in) throws IOException {
    return in.readChar();
  }
  
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException, IllegalAccessException {
    serializingContext.writeChar((Character) obj);
  }
}