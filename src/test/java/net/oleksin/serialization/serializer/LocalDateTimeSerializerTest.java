package net.oleksin.serialization.serializer;

import net.oleksin.serialization.SerializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LocalDateTimeSerializerTest {
  private SerializingContext serializingContext;
  private LocalDateTimeSerializer localDateTimeSerializer;
  
  @BeforeEach
  void setUp() {
    serializingContext = mock(SerializingContext.class);
    localDateTimeSerializer = new LocalDateTimeSerializer();
  }
  
  @Test
  void shouldLocalDateTimeSerialize() throws IOException {
    LocalDateTime localDateTime = LocalDateTime.now();
    localDateTimeSerializer.serialize(serializingContext, localDateTime);
    verify(serializingContext).writeUTF(localDateTime.toString());
  }
  
  @Test
  void shouldCatchClassCastException() {
    LocalDate localDate = LocalDate.now();
    Throwable thrown = assertThrows(ClassCastException.class, () ->
            localDateTimeSerializer.serialize(serializingContext, localDate));
    assertNotNull(thrown.getMessage());
  }
}