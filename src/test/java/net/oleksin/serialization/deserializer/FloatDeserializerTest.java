package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.DeserializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FloatDeserializerTest {
  private DeserializingContext deserializingContext;
  private FloatDeserializer deserializer;
  
  @BeforeEach
  void setUp() {
    deserializingContext = mock(DeserializingContext.class);
    deserializer = new FloatDeserializer();
  }
  
  @Test
  void shouldDeserializeDouble() throws IOException {
    Float aFloat = 0.001f;
    when(deserializingContext.readFloat()).thenReturn(aFloat);
    float val = (float) deserializer.deserialize(deserializingContext, Float.class);
    
    assertEquals(aFloat, val);
    verify(deserializingContext).readFloat();
  }
}