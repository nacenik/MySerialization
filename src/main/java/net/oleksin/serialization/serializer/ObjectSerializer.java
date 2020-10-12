package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectSerializer implements Serializer {
  private final Map<Class<?>, Field[]> fieldCache = new HashMap<>();
  
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException, IllegalAccessException {
    Class<?> klass = obj.getClass();
    Field[] fields = getFields(klass);
    for (Field field : fields) {
      serializingContext.writeFiledName(field.getName());
      Object fieldObj = field.get(obj);
      serializingContext.writeObject(fieldObj);
    }
    
  }
  
  private Field[] getFields(Class<?> klass) {
    Field[] fields = fieldCache.get(klass);
    if (fields == null) {
      fields = klass.getDeclaredFields();
      for (Field field : fields) {
        field.setAccessible(true);
      }
      fieldCache.put(klass, fields);
    }
    return fields;
  }
}