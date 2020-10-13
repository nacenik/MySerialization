package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class MapSerializer implements Serializer {
  
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException, IllegalAccessException {
    Map map = (Map) obj;
    serializingContext.writeInt(map.size());
    Set keySet = map.keySet();
    for (Object key : keySet) {
      serializingContext.writeObject(key);
      serializingContext.writeObject(map.get(key));
    }
    
  }
}
