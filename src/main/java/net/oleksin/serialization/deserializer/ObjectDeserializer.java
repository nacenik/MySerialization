package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.Deserializer;
import net.oleksin.serialization.DeserializingContext;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectDeserializer implements Deserializer {
  private final Map<Class<?>, Field[]> fieldCache = new HashMap<>();
  
  @Override
  public Object deserialize(DeserializingContext deserializingContext, Class<?> klass) throws IllegalAccessException, ClassNotFoundException, InstantiationException,  IOException{
    Object obj = klass.newInstance();
    Field[] fields = getFields(obj.getClass());
    for (Field field : fields) {
      deserializingContext.readFiledName();
      field.set(obj, deserializingContext.readObject());
    }
    return obj;
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