package net.oleksin.serialization;

import net.oleksin.serialization.deserializer.ArrayDeserializer;
import net.oleksin.serialization.deserializer.ObjectDeserializer;

import java.io.DataInputStream;
import java.io.IOException;

public class DeserializingContext {
  private final DataInputStream dataInputStream;
  private final CodeDeserializationFactory codeDeserializationFactory;
  private final Deserializer arrayDeserializer;
  private final Deserializer objectDeserializer;
  private final DeserializingNamesPool deserializingNamesPool;
  
  public DeserializingContext(DataInputStream dataInputStream) {
    this.dataInputStream = dataInputStream;
    codeDeserializationFactory = new CodeDeserializationFactory();
    arrayDeserializer = new ArrayDeserializer();
    objectDeserializer = new ObjectDeserializer();
    deserializingNamesPool = new DeserializingNamesPool();
  }
  
  public Object ReadObject() throws IOException, ClassNotFoundException {
    int objType = dataInputStream.readInt();
    Class klass = Class.forName(deserializingNamesPool.getClassForDeserialize(objType));
    if (klass.isArray()) {
      return arrayDeserializer.deserialize(this);
    }
    
    Deserializer deserializer = codeDeserializationFactory.get(klass);
    if (deserializer != null) {
      return deserializer.deserialize(this);
    }
    
    return objectDeserializer.deserialize(this);
  }
  
  public int readInt() throws IOException {
    return dataInputStream.readInt();
  }
  
  public byte readByte() throws IOException {
    return dataInputStream.readByte();
  }
  
  public short readShort() throws IOException {
    return dataInputStream.readShort();
  }
  
  public long readLong() throws IOException {
    return dataInputStream.readLong();
  }
  
  public float readFloat() throws IOException {
    return dataInputStream.readFloat();
  }
  
  public double readDouble() throws IOException {
    return dataInputStream.readDouble();
  }
  
  public boolean readBoolean() throws IOException {
    return dataInputStream.readBoolean();
  }
  
  public char readChar() throws IOException {
    return dataInputStream.readChar();
  }
  
  public String readUTF() throws IOException {
    return dataInputStream.readUTF();
  }
  
  public int readFiledName() throws IOException {
    return dataInputStream.readInt();
  }
  
}
