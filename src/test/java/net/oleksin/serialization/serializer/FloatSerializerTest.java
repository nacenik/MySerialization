package net.oleksin.serialization.serializer;

import net.oleksin.serialization.SerializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class FloatSerializerTest {
  private SerializingContext serializingContext;
  private FloatSerializer floatSerializer;
  
  @BeforeEach
  void setUp() {
    serializingContext = mock(SerializingContext.class);
    floatSerializer = new FloatSerializer();
  }
  
  @Test
  void shouldWrapperDoubleSerialize() throws IOException {
    Float aFloat = 2.5f;
    floatSerializer.serialize(serializingContext, aFloat);
    verify(serializingContext).writeFloat(aFloat);
  }
  
  @Test
  void shouldPrimitiveDoubleSerialize() throws IOException {
    float aFloat = 5.1f;
    floatSerializer.serialize(serializingContext, aFloat);
    verify(serializingContext).writeFloat(aFloat);
  }
  
  @Test()
  void shouldCatchClassCastException() {
    int fl = 1;
    Throwable thrown = assertThrows(ClassCastException.class, () ->
            floatSerializer.serialize(serializingContext, fl));
    assertNotNull(thrown.getMessage());
  }
  
}