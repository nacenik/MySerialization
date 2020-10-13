package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.DeserializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BooleanDeserializerTest {
  
  private DeserializingContext deserializingContext;
  private BooleanDeserializer deserializer;
  
  @BeforeEach
  void setUp() {
    deserializingContext = mock(DeserializingContext.class);
    deserializer = new BooleanDeserializer();
  }
  
  @Test
  void shouldDeserializeBoolean() throws IOException {
    Boolean bl = true;
    when(deserializingContext.readBoolean()).thenReturn(bl);
    boolean val = (boolean) deserializer.deserialize(deserializingContext, Boolean.class);
    
    assertEquals(bl, val);
    verify(deserializingContext).readBoolean();
  }
}