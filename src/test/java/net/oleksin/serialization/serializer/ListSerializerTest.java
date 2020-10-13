package net.oleksin.serialization.serializer;

import net.oleksin.serialization.SerializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.mockito.Mockito.*;

class ListSerializerTest {
  private SerializingContext serializingContext;
  private ListSerializer listSerializer;
  
  @BeforeEach
  void setUp() {
    serializingContext = mock(SerializingContext.class);
    listSerializer = new ListSerializer();
  }
  
  @Test
  void shouldArrayListSerialize() throws IOException, IllegalAccessException {
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("hello");
    arrayList.add("world");
    arrayList.add("!");
    listSerializer.serialize(serializingContext, arrayList);
    verify(serializingContext).writeInt(arrayList.size());
    verify(serializingContext, times(3)).writeObject(any());
  }
  
  @Test
  void shouldLinkedListSerialize() throws IOException, IllegalAccessException {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add("hello");
    linkedList.add("world");
    linkedList.add("!");
    listSerializer.serialize(serializingContext, linkedList);
    verify(serializingContext).writeInt(linkedList.size());
    verify(serializingContext, times(3)).writeObject(any());
  }
  
}