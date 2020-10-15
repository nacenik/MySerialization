package net.oleksin.serialization.serializer;

import net.oleksin.serialization.SerializingContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class DateSerializerTest {
  
  private SerializingContext serializingContext;
  private DateSerializer dateSerializer;
  
  @BeforeEach
  void setUp() {
    serializingContext = mock(SerializingContext.class);
    dateSerializer = new DateSerializer();
  }
  @Test
  void shouldSerializeDate() throws IOException {
    Date date = new Date();
    dateSerializer.serialize(serializingContext, date);
    verify(serializingContext).writeLong(date.getTime());
  }
}