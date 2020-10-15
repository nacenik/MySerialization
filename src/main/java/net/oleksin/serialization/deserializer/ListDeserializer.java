package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.Deserializer;
import net.oleksin.serialization.DeserializingContext;

import java.io.IOException;
import java.util.List;

public class ListDeserializer implements Deserializer {
  
  @Override
  public Object deserialize(DeserializingContext deserializingContext, Class<?> klass) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
    int size = deserializingContext.readInt();
    List<Object> list = (List<Object>) klass.newInstance();
    for (int i = 0; i < size; i++) {
      list.add(deserializingContext.readObject());
    }
    return list;
  }
}
