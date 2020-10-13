package net.oleksin.serialization.serializer;

import net.oleksin.serialization.SerializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ShortSerializerTest {
  private SerializingContext serializingContext;
  private ShortSerializer shortSerializer;
  
  @BeforeEach
  void setUp() {
    serializingContext = mock(SerializingContext.class);
    shortSerializer = new ShortSerializer();
  }
  
  @Test
  void shouldWrapperShortSerialize() throws IOException {
    Short aShort = 20;
    shortSerializer.serialize(serializingContext, aShort);
    verify(serializingContext).writeShort(aShort);
  }
  
  @Test
  void shouldPrimitiveShortSerialize() throws IOException {
    short aShort = 20;
    shortSerializer.serialize(serializingContext, aShort);
    verify(serializingContext).writeShort(aShort);
  }
  
  @Test()
  void shouldCatchClassCastException() {
    float aShort = 1;
    Throwable thrown = assertThrows(ClassCastException.class, () ->
            shortSerializer.serialize(serializingContext, aShort));
    assertNotNull(thrown.getMessage());
  }
}