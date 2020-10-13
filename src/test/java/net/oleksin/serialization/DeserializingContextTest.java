package net.oleksin.serialization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class DeserializingContextTest {
  
  private DataInputStream dataInputStream;
  private DeserializingContext deserializingContext;
  
  @BeforeEach
  void setUp() {
    dataInputStream = mock(DataInputStream.class);
    deserializingContext = new DeserializingContext(dataInputStream);
  }
  
  @Test
  void shouldReadInt() throws IOException {
    int aInt = 5;
    when(dataInputStream.readInt()).thenReturn(aInt);
    assertEquals(aInt, deserializingContext.readInt());
    verify(dataInputStream).readInt();
  }
  
  @Test
  void shouldReadByte() throws IOException {
    byte aByte = 1;
    when(dataInputStream.readByte()).thenReturn(aByte);
    assertEquals(aByte, deserializingContext.readByte());
    verify(dataInputStream).readByte();
  }
  
  @Test
  void shouldReadShort() throws IOException {
    short aShort = 200;
    when(dataInputStream.readShort()).thenReturn(aShort);
    assertEquals(aShort, deserializingContext.readShort());
    verify(dataInputStream).readShort();
  }
  
  @Test
  void shouldReadLong() throws IOException {
    long aLong = 500L;
    when(dataInputStream.readLong()).thenReturn(aLong);
    assertEquals(aLong, deserializingContext.readLong());
    verify(dataInputStream).readLong();
  }
  
  @Test
  void shouldReadFloat() throws IOException {
    float aFloat = 5.6f;
    when(dataInputStream.readFloat()).thenReturn(aFloat);
    assertEquals(aFloat, deserializingContext.readFloat());
    verify(dataInputStream).readFloat();
  }
  
  @Test
  void shouldReadDouble() throws IOException {
    double aDouble = 5.5d;
    when(dataInputStream.readDouble()).thenReturn(aDouble);
    assertEquals(aDouble, deserializingContext.readDouble());
    verify(dataInputStream).readDouble();
  }
  
  @Test
  void shouldReadBoolean() throws IOException {
    when(dataInputStream.readBoolean()).thenReturn(true);
    assertTrue(deserializingContext.readBoolean());
    verify(dataInputStream).readBoolean();
  }
  
  @Test
  void shouldReadChar() throws IOException {
    char aChar = 'a';
    when(dataInputStream.readChar()).thenReturn(aChar);
    assertEquals(aChar, deserializingContext.readChar());
    verify(dataInputStream).readChar();
  }
  
  @Test
  void shouldReadUTF() throws IOException {
    String str = "Hello";
    when(dataInputStream.readUTF()).thenReturn(str);
    assertEquals(str, deserializingContext.readUTF());
    verify(dataInputStream).readUTF();
  }
}