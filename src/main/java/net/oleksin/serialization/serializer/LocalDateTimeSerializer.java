package net.oleksin.serialization.serializer;

import net.oleksin.serialization.ObjectSerializer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class LocalDateTimeSerializer implements ObjectSerializer {
  @Override
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    LocalDateTime localDateTime = (LocalDateTime) obj;
    out.writeUTF(localDateTime.toString());
  }
  
  @Override
  public LocalDateTime deserialize(DataInputStream in) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
    return LocalDateTime.parse(in.readUTF());
  }
}
