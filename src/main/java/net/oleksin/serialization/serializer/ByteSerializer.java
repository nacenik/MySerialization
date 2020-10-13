package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.IOException;

public class ByteSerializer implements Serializer {
  
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException, IllegalAccessException {
    serializingContext.writeByte((Byte) obj);
  }
}