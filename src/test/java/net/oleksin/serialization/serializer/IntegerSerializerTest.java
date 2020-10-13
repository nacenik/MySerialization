package net.oleksin.serialization.serializer;

import net.oleksin.serialization.SerializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class IntegerSerializerTest {
  private SerializingContext serializingContext;
  private IntegerSerializer integerSerializer;
  
  @BeforeEach
  void setUp() {
    serializingContext = mock(SerializingContext.class);
    integerSerializer = new IntegerSerializer();
  }
  
  @Test
  void shouldWrapperDoubleSerialize() throws IOException {
    Integer integer = 200000;
    integerSerializer.serialize(serializingContext, integer);
    verify(serializingContext).writeInt(integer);
  }
  
  @Test
  void shouldPrimitiveDoubleSerialize() throws IOException {
    int integer = 199919;
    integerSerializer.serialize(serializingContext, integer);
    verify(serializingContext).writeInt(integer);
  }
  
  @Test()
  void shouldCatchClassCastException() {
    float integer = 1;
    Throwable thrown = assertThrows(ClassCastException.class, () ->
            integerSerializer.serialize(serializingContext, integer));
    assertNotNull(thrown.getMessage());
  }
  
}