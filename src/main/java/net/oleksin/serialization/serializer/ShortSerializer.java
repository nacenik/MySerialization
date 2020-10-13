package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.IOException;

public class ShortSerializer implements Serializer {

  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException {
    serializingContext.writeShort((Short) obj);
  }
}