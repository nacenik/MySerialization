package net.oleksin.serialization.serializer;

import net.oleksin.serialization.SerializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CharSerializerTest {
  
  private SerializingContext serializingContext;
  private CharSerializer charSerializer;
  
  @BeforeEach
  void setUp() {
    serializingContext = mock(SerializingContext.class);
    charSerializer = new CharSerializer();
  }
  
  @Test
  void shouldWrapperCharacterSerialize() throws IOException {
    Character character = 'a';
    charSerializer.serialize(serializingContext, character);
    verify(serializingContext).writeChar(character);
  }
  
  @Test
  void shouldPrimitiveCharacterSerialize() throws IOException {
    char character = 'a';
    charSerializer.serialize(serializingContext, character);
    verify(serializingContext).writeChar(character);
  }
  
  @Test()
  void shouldCatchClassCastException() {
    int cr = 1;
    Throwable thrown = assertThrows(ClassCastException.class, () ->
            charSerializer.serialize(serializingContext, cr));
    assertNotNull(thrown.getMessage());
  }
}