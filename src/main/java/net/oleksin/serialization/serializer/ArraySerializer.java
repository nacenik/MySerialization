package net.oleksin.serialization.serializer;

import net.oleksin.serialization.Serializer;
import net.oleksin.serialization.SerializingContext;

import java.io.*;
import java.lang.reflect.Array;

public class ArraySerializer implements Serializer {
  
  public void deserialize(DataInputStream in) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
    Object array = null;
    String str = in.readUTF();
    Class<?> cl = Class.forName(str);
    Class<?> type = cl.getComponentType();
    int size = in.readInt();
    array = Array.newInstance(type, size);
    if (type.isPrimitive()) {
      if (type == Byte.TYPE) {
        in.read((byte[]) array, 0, size);
      } else if (type == Short.TYPE) {
        short[] shorts = new short[size];
        for (int i = 0; i < size; i++) {
          shorts[i] = in.readShort();
        }
        array = shorts;
      } else if (type == Integer.TYPE) {
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
          ints[i] = in.readInt();
        }
        array = ints;
      } else if (type == Long.TYPE) {
        long[] longs = new long[size];
        for (int i = 0; i < size; i++) {
          longs[i] = in.readLong();
        }
        array = longs;
      } else if (type == Float.TYPE) {
        float[] floats = new float[size];
        for (int i = 0; i < size; i++) {
          floats[i] = in.readFloat();
        }
        array = floats;
      } else if (type == Double.TYPE) {
        double[] doubles = new double[size];
        for (int i = 0; i < size; i++) {
          doubles[i] = in.readDouble();
        }
        array = doubles;
      } else if (type == Character.TYPE) {
        char[] chars = new char[size];
        for (int i = 0; i < size; i++) {
          chars[i] = in.readChar();
        }
        array = chars;
      } else if (type == Boolean.TYPE) {
        boolean[] booleans = new boolean[size];
        for (int i = 0; i < size; i++) {
          booleans[i] = in.readBoolean();
        }
        array = booleans;
      } else {
        throw new InternalError();
      }
    } else {
      Object[] objects = new Object[size];
      for (int i = 0; i < size; i++) {
        objects[i] = new ObjectSerializer();
        array = objects;
      }
    }
  }
  
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