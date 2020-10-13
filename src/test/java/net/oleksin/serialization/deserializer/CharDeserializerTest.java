package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.DeserializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CharDeserializerTest {
  
  private DeserializingContext deserializingContext;
  private CharDeserializer deserializer;
  
  @BeforeEach
  void setUp() {
    deserializingContext = mock(DeserializingContext.class);
    deserializer = new CharDeserializer();
  }
  
  @Test
  void shouldDeserializeChar() throws IOException {
    Character cr = '3';
    when(deserializingContext.readChar()).thenReturn(cr);
    char val = (char) deserializer.deserialize(deserializingContext, Character.class);
    
    assertEquals(cr, val);
    verify(deserializingContext).readChar();
  }
}