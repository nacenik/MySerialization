package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.Deserializer;
import net.oleksin.serialization.DeserializingContext;

import java.io.IOException;
import java.util.Date;

public class DateDeserializer implements Deserializer {
  @Override
  public Object deserialize(DeserializingContext deserializingContext, Class<?> klass) throws IOException {
    return new Date(deserializingContext.readLong());
  }
}
