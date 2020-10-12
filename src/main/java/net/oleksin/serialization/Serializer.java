package net.oleksin.serialization;

import java.io.IOException;

public interface Serializer {
  
  void serialize(SerializingContext serializingContext, Object obj) throws IOException, IllegalAccessException;
}
