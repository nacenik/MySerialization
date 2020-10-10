package net.oleksin.serialization;

import net.oleksin.serialization.serializer.IntegerSerializer;
import net.oleksin.serialization.serializer.MapSerializer;
import net.oleksin.serialization.serializer.ObjectSerializerImpl;
import net.oleksin.serialization.serializer.StringSerializer;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * First 7 bytes - NIKITOS
 * long - Names table offset
 * ****Object information
 * Int - Class ID
 * int - field ID
 * Depends on field class:
 *     String: int - String size; String utf-8 bytes
 *     Core classes: field data
 *     Other: Object information
 * Names table
 */
public class MySerializationImpl implements MySerialization {
  
  private final String header = "NIKITOS";
  private long offset = 0;
  private Map<Class<?>, Integer> typeMap;
  private NamesPool namesPool;
  private Map<Integer, ObjectSerializer> serializerMap;
  
  @Override
  public void serializeObject(Object obj, String name) throws IOException {
  
  }
  
  @Override
  public void deserializeObject(Object obj, String name) throws IOException {
  
  }
}
