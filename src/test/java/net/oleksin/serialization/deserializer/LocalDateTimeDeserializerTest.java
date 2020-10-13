package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.DeserializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LocalDateTimeDeserializerTest {
  private DeserializingContext deserializingContext;
  private LocalDateTimeDeserializer deserializer;
  
  @BeforeEach
  void setUp() {
    deserializingContext = mock(DeserializingContext.class);
    deserializer = new LocalDateTimeDeserializer();
  }
  
  @Test
  void shouldDeserializeLocalDateTime() throws IOException {
    LocalDateTime time = LocalDateTime.now();
    when(deserializingContext.readUTF()).thenReturn(time.toString());
    LocalDateTime val = (LocalDateTime) deserializer.deserialize(deserializingContext, LocalDateTime.class);
    
    assertEquals(time, val);
    verify(deserializingContext).readUTF();
  }
}