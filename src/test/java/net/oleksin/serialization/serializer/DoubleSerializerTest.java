package net.oleksin.serialization.serializer;

import net.oleksin.serialization.SerializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class DoubleSerializerTest {
  
  private SerializingContext serializingContext;
  private DoubleSerializer doubleSerializer;
  
  @BeforeEach
  void setUp() {
    serializingContext = mock(SerializingContext.class);
    doubleSerializer = new DoubleSerializer();
  }
  
  @Test
  void shouldWrapperDoubleSerialize() throws IOException {
    Double aDouble = 2.5;
    doubleSerializer.serialize(serializingContext, aDouble);
    verify(serializingContext).writeDouble(aDouble);
  }
  
  @Test
  void shouldPrimitiveDoubleSerialize() throws IOException {
    double aDouble = 5.1;
    doubleSerializer.serialize(serializingContext, aDouble);
    verify(serializingContext).writeDouble(aDouble);
  }
  
  @Test()
  void shouldCatchClassCastException() {
    int dl = 1;
    Throwable thrown = assertThrows(ClassCastException.class, () ->
            doubleSerializer.serialize(serializingContext, dl));
    assertNotNull(thrown.getMessage());
  }
  
}