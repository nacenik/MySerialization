package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.DeserializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DateDeserializerTest {
  private DeserializingContext deserializingContext;
  private DateDeserializer deserializer;
  
  @BeforeEach
  void setUp() {
    deserializingContext = mock(DeserializingContext.class);
    deserializer = new DateDeserializer();
  }
  
  @Test
  void shouldDeserializeDate() throws IOException {
    Date date = new Date();
    when(deserializingContext.readLong()).thenReturn(date.getTime());
    
    Date newDate = (Date) deserializer.deserialize(deserializingContext, Date.class);
    
    assertEquals(date, newDate);
    verify(deserializingContext).readLong();
  }
}