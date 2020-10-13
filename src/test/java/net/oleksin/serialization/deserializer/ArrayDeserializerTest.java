package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.DeserializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArrayDeserializerTest {
  
  private DeserializingContext deserializingContext;
  private ArrayDeserializer deserializer;
  
  @BeforeEach
  void setUp() {
    deserializingContext = mock(DeserializingContext.class);
    deserializer = new ArrayDeserializer();
  }
  
  @Test
  void shouldDeserializeBytes() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
    int size = 5;
    when(deserializingContext.readInt()).thenReturn(size);
    when(deserializingContext.readByte()).thenReturn((byte) 2);
    Object obj = deserializer.deserialize(deserializingContext, byte[].class);
    byte[] bytes = (byte[]) obj;
    assertEquals(size, bytes.length);
    
    verify(deserializingContext).readInt();
    verify(deserializingContext, times(size)).readByte();
  }
  
  @Test
  void shouldDeserializeShorts() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
    int size = 3;
    when(deserializingContext.readInt()).thenReturn(size);
    when(deserializingContext.readShort()).thenReturn((short) 10);
    Object obj = deserializer.deserialize(deserializingContext, short[].class);
    short[] shorts = (short[]) obj;
    assertEquals(size, shorts.length);
    
    verify(deserializingContext).readInt();
    verify(deserializingContext, times(size)).readShort();
  }
  
  @Test
  void shouldDeserializeInts() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
    int size = 7;
    when(deserializingContext.readInt()).thenReturn(size);
    Object obj = deserializer.deserialize(deserializingContext, int[].class);
    int[] ints = (int[]) obj;
    assertEquals(size, ints.length);
    
    verify(deserializingContext, times(size + 1)).readInt();
  }
  
  @Test
  void shouldDeserializeLongs() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
    int size = 15;
    when(deserializingContext.readInt()).thenReturn(size);
    when(deserializingContext.readLong()).thenReturn(10L);
    Object obj = deserializer.deserialize(deserializingContext, long[].class);
    long[] longs = (long[]) obj;
    assertEquals(size, longs.length);
    
    verify(deserializingContext).readInt();
    verify(deserializingContext, times(size)).readLong();
  }
  
  @Test
  void shouldDeserializeFloats() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
    int size = 7;
    when(deserializingContext.readInt()).thenReturn(size);
    when(deserializingContext.readFloat()).thenReturn(5.02f);
    Object obj = deserializer.deserialize(deserializingContext, float[].class);
    float[] floats = (float[]) obj;
    assertEquals(size, floats.length);
    
    verify(deserializingContext).readInt();
    verify(deserializingContext, times(size)).readFloat();
  }
  
  @Test
  void shouldDeserializeDoubles() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
    int size = 8;
    when(deserializingContext.readInt()).thenReturn(size);
    when(deserializingContext.readDouble()).thenReturn(10.674);
    Object obj = deserializer.deserialize(deserializingContext, double[].class);
    double[] doubles = (double[]) obj;
    assertEquals(size, doubles.length);
    
    verify(deserializingContext).readInt();
    verify(deserializingContext, times(size)).readDouble();
  }
  
  @Test
  void shouldDeserializeChars() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
    int size = 4;
    when(deserializingContext.readInt()).thenReturn(size);
    when(deserializingContext.readChar()).thenReturn('f');
    Object obj = deserializer.deserialize(deserializingContext, char[].class);
    char[] chars = (char[]) obj;
    assertEquals(size, chars.length);
    
    verify(deserializingContext).readInt();
    verify(deserializingContext, times(size)).readChar();
  }
  
  @Test
  void shouldDeserializeBooleans() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
    int size = 10;
    when(deserializingContext.readInt()).thenReturn(size);
    when(deserializingContext.readBoolean()).thenReturn(true);
    Object obj = deserializer.deserialize(deserializingContext, boolean[].class);
    boolean[] booleans = (boolean[]) obj;
    assertEquals(size, booleans.length);
    
    verify(deserializingContext).readInt();
    verify(deserializingContext, times(size)).readBoolean();
  }
  
  @Test
  void shouldDeserializeObjects() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
    int size = 2;
    when(deserializingContext.readInt()).thenReturn(size);
    when(deserializingContext.readObject()).thenReturn(new Object());
    Object obj = deserializer.deserialize(deserializingContext, Object[].class);
    Object[] shorts = (Object[]) obj;
    assertEquals(size, shorts.length);
    
    verify(deserializingContext).readInt();
    verify(deserializingContext, times(size)).readObject();
  }
}