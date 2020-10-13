package net.oleksin.serialization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.DataOutputStream;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SerializingContextTest {
  
  private DataOutputStream dataOutputStream;
  private SerializingContext serializingContext;
  
  @BeforeEach
  void setUp() {
    dataOutputStream = mock(DataOutputStream.class);
    serializingContext = new SerializingContext(dataOutputStream);
  }
  
  @Test
  void shouldWriteInt() throws IOException {
    int val = 5;
    serializingContext.writeInt(val);
    verify(dataOutputStream).writeInt(val);
  }
  
  @Test
  void shouldWriteByte() throws IOException {
    byte val = -4;
    serializingContext.writeByte(val);
    verify(dataOutputStream).writeByte(val);
  }
  
  @Test
  void shouldWriteShort() throws IOException {
    short val = -200;
    serializingContext.writeShort(val);
    verify(dataOutputStream).writeShort(val);
  }
  
  @Test
  void shouldWriteLong() throws IOException {
    long val = 5000L;
    serializingContext.writeLong(val);
    verify(dataOutputStream).writeLong(val);
  }
  
  @Test
  void shouldWriteFloat() throws IOException {
    float val = 2.5f;
    serializingContext.writeFloat(val);
    verify(dataOutputStream).writeFloat(val);
  }
  
  @Test
  void shouldWriteDouble() throws IOException {
    double val = 1000.0001;
    serializingContext.writeDouble(val);
    verify(dataOutputStream).writeDouble(val);
  }
  
  @Test
  void shouldWriteChar() throws IOException {
    char val = '-';
    serializingContext.writeChar(val);
    verify(dataOutputStream).writeChar(val);
  }
  
  @Test
  void shouldWriteBoolean() throws IOException {
    boolean val = true;
    serializingContext.writeBoolean(val);
    verify(dataOutputStream).writeBoolean(val);
  }
  
  @Test
  void shouldWriteUTF() throws IOException {
    String val = "Hello";
    serializingContext.writeUTF(val);
    verify(dataOutputStream).writeUTF(val);
  }
}