package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.DeserializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MapDeserializerTest {
  
  private DeserializingContext deserializingContext;
  private MapDeserializer deserializer;
  
  @BeforeEach
  void setUp() {
    deserializingContext = mock(DeserializingContext.class);
    deserializer = new MapDeserializer();
  }
  
  @Test
  void shouldDeserializeHashMap() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
    String str = "string";
    Object obj = new Object();
    int size = 1;
    when(deserializingContext.readInt()).thenReturn(size);
    when(deserializingContext.readObject()).thenReturn(str);
    when(deserializingContext.readObject()).thenReturn(obj);
    HashMap val = (HashMap) deserializer.deserialize(deserializingContext, HashMap.class);
    
    assertEquals(size, val.size());
    verify(deserializingContext).readInt();
    verify(deserializingContext, times(size * 2)).readObject();
  }
  
}