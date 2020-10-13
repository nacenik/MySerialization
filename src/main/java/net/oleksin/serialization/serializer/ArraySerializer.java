package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.IOException;

public class ArraySerializer implements Serializer {
  
  @Override
  public void serialize(SerializingContext serializingContext, Object obj) throws IOException, IllegalAccessException {
    Class<?> type = obj.getClass().getComponentType();
    if (type.isPrimitive()) {
      if (type == Byte.TYPE) {
        byte[] bytes = (byte[]) obj;
        serializingContext.writeInt(bytes.length);
        for (byte aByte : bytes) {
          serializingContext.writeByte(aByte);
        }
      } else if (type == Short.TYPE) {
        short[] shorts = (short[]) obj;
        serializingContext.writeInt(shorts.length);
        for (short aShort : shorts) {
          serializingContext.writeShort(aShort);
        }
      } else if (type == Integer.TYPE) {
        int[] ints = (int[]) obj;
        serializingContext.writeInt(ints.length);
        for (int anInt : ints) {
          serializingContext.writeInt(anInt);
        }
      } else if (type == Long.TYPE) {
        long[] longs = (long[]) obj;
        serializingContext.writeInt(longs.length);
        for (long along : longs) {
          serializingContext.writeLong(along);
        }
      } else if (type == Float.TYPE) {
        float[] floats = (float[]) obj;
        serializingContext.writeInt(floats.length);
        for (float aFloat : floats) {
          serializingContext.writeFloat(aFloat);
        }
      } else if (type == Double.TYPE) {
        double[] doubles = (double[]) obj;
        serializingContext.writeInt(doubles.length);
        for (double aDouble : doubles) {
          serializingContext.writeDouble(aDouble);
        }
      } else if (type == Character.TYPE) {
        char[] chars = (char[]) obj;
        serializingContext.writeInt(chars.length);
        for (Character aChar : chars) {
          serializingContext.writeChar(aChar);
        }
      } else if (type == Boolean.TYPE) {
        boolean[] booleans = (boolean[]) obj;
        serializingContext.writeInt(booleans.length);
        for (boolean aBoolean : booleans) {
          serializingContext.writeBoolean(aBoolean);
        }
      } else {
        throw new InternalError();
      }
    } else {
      Object[] objects = (Object[]) obj;
      serializingContext.writeInt(objects.length);
      for (Object o : objects) {
        serializingContext.writeObject(o);
      }
    }
  }
}