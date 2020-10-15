package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.Deserializer;
import net.oleksin.serialization.DeserializingContext;

import java.io.IOException;
import java.util.Map;

public class MapDeserializer implements Deserializer {
  
  @Override
  public Object deserialize(DeserializingContext deserializingContext, Class<?> klass) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
    Map<Object, Object> map = (Map<Object, Object>) klass.newInstance();
    int size = deserializingContext.readInt();
    for (int i = 0; i < size; i++) {
      map.put(deserializingContext.readObject(), deserializingContext.readObject());
    }
    return map;
  }
}
