package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.IOException;
import java.util.Date;

public class DateSerializer implements Serializer {
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException {
    Date date = (Date) obj;
    serializingContext.writeLong(date.getTime());
  }
}
