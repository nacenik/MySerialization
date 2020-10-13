package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.DeserializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShortDeserializerTest {
  private DeserializingContext deserializingContext;
  private ShortDeserializer deserializer;
  
  @BeforeEach
  void setUp() {
    deserializingContext = mock(DeserializingContext.class);
    deserializer = new ShortDeserializer();
  }
  
  @Test
  void shouldDeserializeDouble() throws IOException {
    Short aShort = 55;
    when(deserializingContext.readShort()).thenReturn(aShort);
    short val = (short) deserializer.deserialize(deserializingContext, Short.class);
    
    assertEquals(aShort, val);
    verify(deserializingContext).readShort();
  }
}