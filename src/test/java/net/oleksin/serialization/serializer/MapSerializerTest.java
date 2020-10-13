package net.oleksin.serialization.serializer;

import net.oleksin.serialization.SerializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MapSerializerTest {
  private SerializingContext serializingContext;
  private MapSerializer mapSerializer;
  
  @BeforeEach
  void setUp() {
    serializingContext = mock(SerializingContext.class);
    mapSerializer = new MapSerializer();
  }
  
  @Test
  void shouldHashMapSerialize() throws IOException, IllegalAccessException {
    HashMap<String, Integer> hashMap = new HashMap<>();
    hashMap.put("Hello", 1);
    hashMap.put("world", 2);
    hashMap.put("!", 3);
    mapSerializer.serialize(serializingContext, hashMap);
    verify(serializingContext).writeInt(hashMap.size());
    verify(serializingContext, times(6)).writeObject(any());
  }
  
}