package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.Deserializer;
import net.oleksin.serialization.DeserializingContext;

import java.io.IOException;

public class BooleanDeserializer implements Deserializer {
  
  @Override
  public Object deserialize(DeserializingContext deserializingContext, Class<?> klass) throws IOException {
    return deserializingContext.readBoolean();
  }
}