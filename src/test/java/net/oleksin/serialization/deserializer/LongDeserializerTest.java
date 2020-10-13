package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.DeserializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LongDeserializerTest {
  private DeserializingContext deserializingContext;
  private LongDeserializer deserializer;
  
  @BeforeEach
  void setUp() {
    deserializingContext = mock(DeserializingContext.class);
    deserializer = new LongDeserializer();
  }
  
  @Test
  void shouldDeserializeLong() throws IOException {
    Long aLong = 555L;
    when(deserializingContext.readLong()).thenReturn(aLong);
    long val = (long) deserializer.deserialize(deserializingContext, Long.class);
    
    assertEquals(aLong, val);
    verify(deserializingContext).readLong();
  }
}