package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.DeserializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DoubleDeserializerTest {
  private DeserializingContext deserializingContext;
  private DoubleDeserializer deserializer;
  
  @BeforeEach
  void setUp() {
    deserializingContext = mock(DeserializingContext.class);
    deserializer = new DoubleDeserializer();
  }
  
  @Test
  void shouldDeserializeDouble() throws IOException {
    Double aDouble = 5.5;
    when(deserializingContext.readDouble()).thenReturn(aDouble);
    double val = (double) deserializer.deserialize(deserializingContext, Double.class);
    
    assertEquals(aDouble, val);
    verify(deserializingContext).readDouble();
  }
}