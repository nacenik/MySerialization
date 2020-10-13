package net.oleksin.serialization.serializer;

import net.oleksin.serialization.SerializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LongSerializerTest {
  private SerializingContext serializingContext;
  private LongSerializer longSerializer;
  
  @BeforeEach
  void setUp() {
    serializingContext = mock(SerializingContext.class);
    longSerializer = new LongSerializer();
  }
  
  @Test
  void shouldWrapperLongSerialize() throws IOException {
    Long aLong = 200000L;
    longSerializer.serialize(serializingContext, aLong);
    verify(serializingContext).writeLong(aLong);
  }
  
  @Test
  void shouldPrimitiveLongSerialize() throws IOException {
    long aLong = 20000012L;
    longSerializer.serialize(serializingContext, aLong);
    verify(serializingContext).writeLong(aLong);
  }
  
  @Test()
  void shouldCatchClassCastException() {
    float aLong = 1;
    Throwable thrown = assertThrows(ClassCastException.class, () ->
            longSerializer.serialize(serializingContext, aLong));
    assertNotNull(thrown.getMessage());
  }
}