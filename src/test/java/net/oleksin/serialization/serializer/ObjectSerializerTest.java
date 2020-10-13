package net.oleksin.serialization.serializer;

import net.oleksin.serialization.SerializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ObjectSerializerTest {
  private SerializingContext serializingContext;
  private ObjectSerializer objectSerializer;
  
  @BeforeEach
  void setUp() {
    serializingContext = mock(SerializingContext.class);
    objectSerializer = new ObjectSerializer();
  }
  
  @Test
  void shouldObjectSerialize() throws IOException, IllegalAccessException {
    class Test{
      int a = 5;
      String string = "test";
    }
    Test test = new Test();
    objectSerializer.serialize(serializingContext, test);
    verify(serializingContext, times(3)).writeFiledName(anyString());
    verify(serializingContext, times(3)).writeObject(any());
  }
}