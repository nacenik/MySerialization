package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.IOException;
import java.time.LocalDateTime;

public class LocalDateTimeSerializer implements Serializer {
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException {
    LocalDateTime localDateTime = (LocalDateTime) obj;
    serializingContext.writeUTF(localDateTime.toString());
  }
}
