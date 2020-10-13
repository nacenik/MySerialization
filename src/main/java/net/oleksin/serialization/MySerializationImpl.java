package net.oleksin.serialization;

import java.io.*;

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
  
  @Override
  public void serializeObject(Object obj, String name) throws IOException {
    try (DataOutputStream oout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(name)))) {
      SerializingContext serializingContext = new SerializingContext(oout);
      oout.write(header.getBytes());
      oout.writeLong(offset);
      serializingContext.writeObject(obj);
      offset = oout.size() - header.length();
      serializingContext.writeNamesPool();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } finally {
      writeOffset(name);
    }
  }
  
  private void writeOffset(String name) throws IOException {
    try (RandomAccessFile raf = new RandomAccessFile(name, "rw")) {
      raf.seek(header.length());
      raf.writeLong(offset);
    }
  }
  
  @Override
  public Object deserializeObject(String name) throws IOException {
    try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(name)))) {
      DeserializingContext deserializingContext = new DeserializingContext(in);
      byte[] headerBytes = new byte[header.length()];
      in.read(headerBytes);
      String fileHeader = new String(headerBytes);
      long fileOffset = in.readLong();
      if (fileHeader.equals(header)) {
        RandomAccessFile raf = new RandomAccessFile(name, "rw");
        raf.seek(fileOffset + header.length());
        deserializingContext.setDeserializingNamesPool(raf);
        return deserializingContext.readObject();
      } else {
        throw new NotSerializableException();
      }
    } catch (NotSerializableException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }
}


