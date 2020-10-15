package net.oleksin.serialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

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
  private final byte[] headerBytes = "NIKITOS".getBytes();
  
  @Override
  public void serializeObject(Object obj, String name) throws IOException {
    try (DataOutputStream oout = new DataOutputStream(new BufferedOutputStream(
            Files.newOutputStream(Paths.get(name))))) {
      long namesTableOffset = 0;
      SerializingContext serializingContext = new SerializingContext(oout);
      oout.write(headerBytes);
      oout.writeLong(namesTableOffset);
      serializingContext.writeObject(obj);
      namesTableOffset = oout.size() - headerBytes.length;
      serializingContext.writeNamesPool();
      oout.flush();
      writeOffset(name, namesTableOffset);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
  
  private void writeOffset(String name, long offset) throws IOException {
    try (RandomAccessFile raf = new RandomAccessFile(name, "rw")) {
      raf.seek(headerBytes.length);
      raf.writeLong(offset);
    }
  }
  
  @Override
  public Object deserializeObject(String name) throws IOException {
    try (DataInputStream in = new DataInputStream(new BufferedInputStream(
            Files.newInputStream(Paths.get(name))))) {
      DeserializingContext deserializingContext = new DeserializingContext(in);
      byte[] fileHeaderBytes = new byte[headerBytes.length];
      in.read(fileHeaderBytes);
      long namesTableOffset = in.readLong();
      if (headerTest(headerBytes, fileHeaderBytes)) {
        RandomAccessFile raf = new RandomAccessFile(name, "r");
        raf.seek(namesTableOffset + headerBytes.length);
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
  
  private boolean headerTest(byte[] header, byte[]fileHeader) {
    for (int i = 0; i < header.length; i++) {
      if (header[i] != fileHeader[i]){
        return false;
      }
    }
    return true;
  }
}


