package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.IOException;

public class CharSerializer implements Serializer {
  
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException, IllegalAccessException {
    serializingContext.writeChar((Character) obj);
  }
}