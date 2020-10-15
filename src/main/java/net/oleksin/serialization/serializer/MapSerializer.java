package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.IOException;
import java.util.Map;

public class MapSerializer implements Serializer {
  
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException, IllegalAccessException {
    Map<?, ?> map = (Map<?, ?>) obj;
    serializingContext.writeInt(map.size());
    for (Map.Entry<?, ?> entry : map.entrySet()) {
      serializingContext.writeObject(entry.getKey());
      serializingContext.writeObject(entry.getValue());
    }
    
  }
}
