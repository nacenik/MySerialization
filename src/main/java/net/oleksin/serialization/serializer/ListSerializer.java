package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.IOException;
import java.util.List;

public class ListSerializer implements Serializer {
  
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException, IllegalAccessException {
    List<?> list = (List<?>) obj;
    serializingContext.writeInt(list.size());
    for (Object o : list) {
      serializingContext.writeObject(o);
    }
  }
}
