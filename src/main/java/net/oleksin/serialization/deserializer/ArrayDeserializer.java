package net.oleksin.serialization.deserializer;

import net.oleksin.serialization.Deserializer;
import net.oleksin.serialization.DeserializingContext;

import java.io.IOException;
import java.lang.reflect.Array;

public class ArrayDeserializer implements Deserializer {
  @Override
  public Object deserialize(DeserializingContext deserializingContext, Class<?> klass) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
    Object array = null;
    Class<?> cl = klass.getComponentType();
    int size = deserializingContext.readInt();
    array = Array.newInstance(cl, size);
    if (cl.isPrimitive()) {
      if (cl == Byte.TYPE) {
        byte[] bytes = (byte[]) array;
        for (int i = 0; i < size; i++) {
          bytes[i] = deserializingContext.readByte();
        }
        return bytes;
      } else if (cl == Short.TYPE) {
        short[] shorts = (short[]) array;
        for (int i = 0; i < size; i++) {
          shorts[i] = deserializingContext.readShort();
        }
        return shorts;
      } else if (cl == Integer.TYPE) {
        int[] ints = (int[]) array;
        for (int i = 0; i < size; i++) {
          ints[i] = deserializingContext.readInt();
        }
        return ints;
      } else if (cl == Long.TYPE) {
        long[] longs = (long[]) array;
        for (int i = 0; i < size; i++) {
          longs[i] = deserializingContext.readLong();
        }
        return longs;
      } else if (cl == Float.TYPE) {
        float[] floats = (float[]) array;
        for (int i = 0; i < size; i++) {
          floats[i] = deserializingContext.readFloat();
        }
        return floats;
      } else if (cl == Double.TYPE) {
        double[] doubles = (double[]) array;
        for (int i = 0; i < size; i++) {
          doubles[i] = deserializingContext.readDouble();
        }
        return doubles;
      } else if (cl == Character.TYPE) {
        char[] chars = (char[]) array;
        for (int i = 0; i < size; i++) {
          chars[i] = deserializingContext.readChar();
        }
        return chars;
      } else if (cl == Boolean.TYPE) {
        boolean[] booleans = (boolean[]) array;
        for (int i = 0; i < size; i++) {
          booleans[i] = deserializingContext.readBoolean();
        }
        return booleans;
      }
    } else {
      Object[] arr = (Object[]) array;
      for (int i = 0; i < size; i++) {
        arr[i] = deserializingContext.readObject();
      }
    }
    return array;
  }
}