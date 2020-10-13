package net.oleksin.serialization;

import java.io.IOException;

public interface Deserializer {
  
  Object deserialize(DeserializingContext serializingContext) throws IOException;
}
