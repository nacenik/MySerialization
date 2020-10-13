package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.DeserializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ByteDeserializerTest {
  
  private DeserializingContext deserializingContext;
  private ByteDeserializer deserializer;
  
  @BeforeEach
  void setUp() {
    deserializingContext = mock(DeserializingContext.class);
    deserializer = new ByteDeserializer();
  }
  
  @Test
  void shouldDeserializeByte() throws IOException {
    Byte bt = 2;
    when(deserializingContext.readByte()).thenReturn(bt);
    byte val = (byte) deserializer.deserialize(deserializingContext, Byte.class);
    
    assertEquals(bt, val);
    verify(deserializingContext).readByte();
  }
  
}