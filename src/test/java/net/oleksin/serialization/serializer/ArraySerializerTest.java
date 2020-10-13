package net.oleksin.serialization.serializer;

import net.oleksin.serialization.SerializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class ArraySerializerTest {
  
  private SerializingContext serializingContext;
  private ArraySerializer arraySerializer;
  
  @BeforeEach
  void setUp() {
    serializingContext = mock(SerializingContext.class);
    arraySerializer = new ArraySerializer();
  }
  
  @Test
  void shouldSerializeBytes() throws IOException, IllegalAccessException {
    byte[] bytes = new byte[]{1, 2, 3, 4, 5};
    arraySerializer.serialize(serializingContext, bytes);
    verify(serializingContext).writeInt(anyInt());
    verify(serializingContext, times(5)).writeByte(anyByte());
  }
  
  @Test
  void shouldSerializeShorts() throws IOException, IllegalAccessException {
    short[] shorts = new short[]{1, 2, 3, 4, 5};
    arraySerializer.serialize(serializingContext, shorts);
    verify(serializingContext).writeInt(anyInt());
    verify(serializingContext, times(5)).writeShort(anyShort());
  }
  
  @Test
  void shouldSerializeInts() throws IOException, IllegalAccessException {
    int[] ints = new int[]{1, 2, 3, 4, 5};
    arraySerializer.serialize(serializingContext, ints);
    verify(serializingContext, times(6)).writeInt(anyInt());
  }
  
  @Test
  void shouldSerializeLongs() throws IOException, IllegalAccessException {
    long[] longs= new long[]{1L, 2L, 3L, 4L, 5L};
    arraySerializer.serialize(serializingContext, longs);
    verify(serializingContext).writeInt(anyInt());
    verify(serializingContext, times(5)).writeLong(anyLong());
  }
  
  @Test
  void shouldSerializeFloats() throws IOException, IllegalAccessException {
    float[] floats = new float[]{1.4f, 2.5f, 3.6f, 4.2f, 5.3f};
    arraySerializer.serialize(serializingContext, floats);
    verify(serializingContext).writeInt(anyInt());
    verify(serializingContext, times(5)).writeFloat(anyFloat());
  }
  
  @Test
  void shouldSerializeDoubles() throws IOException, IllegalAccessException {
    double[] doubles = new double[]{1.4, 2.5, 3.6, 4.7, 5.8};
    arraySerializer.serialize(serializingContext, doubles);
    verify(serializingContext).writeInt(anyInt());
    verify(serializingContext, times(5)).writeDouble(anyDouble());
  }
  
  @Test
  void shouldSerializeChars() throws IOException, IllegalAccessException {
    char[] chars = new char[]{'a', 's', 'd', 'f', 'g'};
    arraySerializer.serialize(serializingContext, chars);
    verify(serializingContext).writeInt(anyInt());
    verify(serializingContext, times(5)).writeChar(anyChar());
  }
  
  @Test
  void shouldSerializeBooleans() throws IOException, IllegalAccessException {
    boolean[] booleans = new boolean[]{true, false, true, false, true};
    arraySerializer.serialize(serializingContext, booleans);
    verify(serializingContext).writeInt(anyInt());
    verify(serializingContext, times(5)).writeBoolean(anyBoolean());
  }
  
  @Test
  void shouldSerializeObjects() throws IOException, IllegalAccessException {
    Object[] objects = new Object[]
            {new Object(), new Object(), new Object(), new Object(), new Object()};
    arraySerializer.serialize(serializingContext, objects);
    verify(serializingContext).writeInt(anyInt());
    verify(serializingContext, times(5)).writeObject(any());
  }
  
}