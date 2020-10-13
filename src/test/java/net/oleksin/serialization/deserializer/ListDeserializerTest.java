package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.DeserializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ListDeserializerTest {
  private DeserializingContext deserializingContext;
  private ListDeserializer deserializer;
  
  @BeforeEach
  void setUp() {
    deserializingContext = mock(DeserializingContext.class);
    deserializer = new ListDeserializer();
  }
  
  @Test
  void shouldDeserializeArrayList() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
    String str= "string";
    int size = 5;
    when(deserializingContext.readInt()).thenReturn(size);
    when(deserializingContext.readObject()).thenReturn(str);
    ArrayList val = (ArrayList) deserializer.deserialize(deserializingContext, ArrayList.class);
    
    assertEquals(size, val.size());
    verify(deserializingContext).readInt();
    verify(deserializingContext, times(size)).readObject();
  }
  
  @Test
  void shouldDeserializeLinkedList() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
    String str= "string";
    int size = 5;
    when(deserializingContext.readInt()).thenReturn(size);
    when(deserializingContext.readObject()).thenReturn(str);
    LinkedList val = (LinkedList) deserializer.deserialize(deserializingContext, LinkedList.class);
    
    assertEquals(size, val.size());
    verify(deserializingContext).readInt();
    verify(deserializingContext, times(size)).readObject();
  }
}