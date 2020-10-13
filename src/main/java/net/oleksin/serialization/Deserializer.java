package net.oleksin.serialization;

import java.io.IOException;

public interface Deserializer {
  
  Object deserialize(DeserializingContext deserializingContext, Class<?> klass) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException;
}
