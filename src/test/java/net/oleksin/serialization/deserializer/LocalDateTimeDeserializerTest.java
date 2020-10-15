package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.DeserializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    when(deserializingContext.readInt()).thenReturn(LocalDateTime.now().getMonthValue());
    LocalDateTime val = (LocalDateTime) deserializer.deserialize(deserializingContext, LocalDateTime.class);
    
    assertNotNull(val);
    verify(deserializingContext, times(7)).readInt();
  }
}