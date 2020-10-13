package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.DeserializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IntegerDeserializerTest {
  private DeserializingContext deserializingContext;
  private IntegerDeserializer deserializer;
  
  @BeforeEach
  void setUp() {
    deserializingContext = mock(DeserializingContext.class);
    deserializer = new IntegerDeserializer();
  }
  
  @Test
  void shouldDeserializeInteger() throws IOException {
    Integer integer = 1000;
    when(deserializingContext.readInt()).thenReturn(integer);
    int val = (int) deserializer.deserialize(deserializingContext, Integer.class);
    
    assertEquals(integer, val);
    verify(deserializingContext).readInt();
  }
  
}