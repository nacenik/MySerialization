package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.DeserializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ObjectDeserializerTest {
  
  private DeserializingContext deserializingContext;
  private ObjectDeserializer deserializer;
  
  @BeforeEach
  void setUp() {
    deserializingContext = mock(DeserializingContext.class);
    deserializer = new ObjectDeserializer();
  }
  
  @Test
  void shouldDeserializeObject() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
    when(deserializingContext.readObject()).thenReturn( new Object());
    Object val = deserializer.deserialize(deserializingContext, Object.class);
    
    assertNotNull(val);
  }
}