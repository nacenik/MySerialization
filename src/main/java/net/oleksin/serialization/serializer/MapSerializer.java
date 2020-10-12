package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class MapSerializer implements Serializer {

  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Map map = (Map) obj;
    Set keySet = map.keySet();
    out.writeUTF(map.getClass().toString());
    out.writeInt(map.size());
    for (int i = 0; i < map.size(); i++) {
      out.writeUTF(String.valueOf(keySet.toArray()[i]));
      out.writeUTF(String.valueOf(map.get(map.keySet().toArray()[i])));
    }
  }
  
  public Map deserialize(DataInputStream in) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
    Class mapClass = Class.forName(in.readUTF());
    Map map = (Map) mapClass.newInstance();
    int size = in.readInt();
    for (int i = 0; i < size; i++) {
      Object keyObject = in.readInt();
      Object valueObject = in.readInt();
      map.put(keyObject, valueObject);
    }
    return map;
  }
  
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
