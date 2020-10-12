package net.oleksin.serialization;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * First 7 bytes - NIKITOS
 * long - Names table offset
 * ****Object information
 * Int - Class ID
 * int - field ID
 * Depends on field class:
 *     String: int - String size; String utf-8 bytes
 *     Core classes: field data
 *     Other: Object information
 * Names table
 */
public class MySerializationImpl implements MySerialization {
  
  private final String header = "NIKITOS";
  private long offset = 0;
  private SerializingContext serializingContext;
  
  @Override
  public void serializeObject(Object obj, String name) throws IOException {
    try (DataOutputStream oout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(name)))) {
      serializingContext = new SerializingContext(oout);
      oout.write(header.getBytes());
      oout.writeLong(offset);
      serializingContext.writeObject(obj);
      offset = oout.size() - header.length();
      writeNamesPool(name);
      serializingContext.writeNamesPool();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
  
  private void writeNamesPool(String name) throws IOException {
    ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
    buffer.putLong(offset);
    try (RandomAccessFile raf = new RandomAccessFile(name, "rw")) {
      raf.seek(header.length());
      raf.write(buffer.array());
    }
  }
  
  @Override
  public Object deserializeObject(String name) throws IOException {
    return null;
  }
}

