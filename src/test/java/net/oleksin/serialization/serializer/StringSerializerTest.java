package net.oleksin.serialization.serializer;

import net.oleksin.serialization.SerializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class StringSerializerTest {
  private SerializingContext serializingContext;
  private StringSerializer stringSerializer;
  
  @BeforeEach
  void setUp() {
    serializingContext = mock(SerializingContext.class);
    stringSerializer = new StringSerializer();
  }
  
  @Test
  void shouldObjectSerialize() throws IOException, IllegalAccessException {
    String str = "Hello!!!!";
    stringSerializer.serialize(serializingContext, str);
    verify(serializingContext).writeUTF(str);
  }
}