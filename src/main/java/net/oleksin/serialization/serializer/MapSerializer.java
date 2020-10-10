package net.oleksin.serialization.serializer;

import net.oleksin.serialization.ObjectSerializer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSerializer implements ObjectSerializer {
  
  @Override
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Map map = (Map) obj;
    Set keySet = map.keySet();
    out.writeInt(map.size());
    for (int i = 0; i < map.size(); i++) {
      out.writeUTF(String.valueOf(keySet.toArray()[i]));
      out.writeUTF(String.valueOf(map.get(map.keySet().toArray()[i])));
    }
  }
  
  @Override
  public Map deserialize(DataInputStream in) throws IOException {
    Map map = new HashMap();
    for (int i = 0; i < in.readInt(); i++) {
      map.put(in.readUTF(), in.readUTF());
    }
    return map;
  }
}
