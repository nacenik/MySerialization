package net.oleksin.serialization.serializer;

import net.oleksin.serialization.SerializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ByteSerializerTest {
  private SerializingContext serializingContext;
  private ByteSerializer byteSerializer;
  
  @BeforeEach
  void setUp() {
    serializingContext = mock(SerializingContext.class);
    byteSerializer = new ByteSerializer();
  }
  
  @Test
  void shouldWrapperByteSerialize() throws IOException {
    Byte bt = 0;
    byteSerializer.serialize(serializingContext, bt);
    verify(serializingContext).writeByte(bt);
  }
  
  @Test
  void shouldPrimitiveByteSerialize() throws IOException {
    byte bt = 127;
    byteSerializer.serialize(serializingContext, bt);
    verify(serializingContext).writeByte(bt);
  }
  
  @Test()
  void shouldCatchClassCastException() throws IOException {
    int bt = 1;
    Throwable thrown = assertThrows(ClassCastException.class, () ->
            byteSerializer.serialize(serializingContext, bt));
    assertNotNull(thrown.getMessage());
  }
}