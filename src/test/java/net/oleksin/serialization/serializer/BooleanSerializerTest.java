package net.oleksin.serialization.serializer;

import net.oleksin.serialization.SerializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BooleanSerializerTest {
  
  private SerializingContext serializingContext;
  private BooleanSerializer booleanSerializer;
  
  @BeforeEach
  void setUp() {
    serializingContext = mock(SerializingContext.class);
    booleanSerializer = new BooleanSerializer();
  }
  
  @Test
  void shouldWrapperBooleanSerialize() throws IOException {
    Boolean bl = Boolean.TRUE;
    booleanSerializer.serialize(serializingContext, bl);
    verify(serializingContext).writeBoolean(bl);
  }
  
  @Test
  void shouldPrimitiveBooleanSerialize() throws IOException {
    boolean bl =false;
    booleanSerializer.serialize(serializingContext, bl);
    verify(serializingContext).writeBoolean(bl);
  }
  
  @Test()
  void shouldCatchClassCastException() throws IOException {
    int bl = 1;
    Throwable thrown = assertThrows(ClassCastException.class, () ->
            booleanSerializer.serialize(serializingContext, bl));
    assertNotNull(thrown.getMessage());
  }
}