package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.Deserializer;
import net.oleksin.serialization.DeserializingContext;

import java.io.IOException;
import java.time.LocalDateTime;

public class LocalDateTimeDeserializer implements Deserializer {
  
  @Override
  public Object deserialize(DeserializingContext deserializingContext, Class<?> klass) throws IOException {
    return LocalDateTime.of(deserializingContext.readInt(),
            deserializingContext.readInt(),
            deserializingContext.readInt(),
            deserializingContext.readInt(),
            deserializingContext.readInt(),
            deserializingContext.readInt(),
            deserializingContext.readInt());
  }
}
