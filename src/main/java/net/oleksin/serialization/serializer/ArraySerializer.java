package net.oleksin.serialization.serializer;

import net.oleksin.serialization.ObjectSerializer;

import java.io.*;
import java.lang.reflect.Array;

public class ArraySerializer implements ObjectSerializer {
  
  @Override
  public void serialize(DataOutputStream out, Object obj) throws IOException {
    Class<?> cl = obj.getClass();
    out.writeUTF(cl.getName());
    Class<?> type = cl.getComponentType();
    if(type.isPrimitive()) {
      if (type == Byte.TYPE) {
        byte[] bytes = (byte[]) obj;
        out.writeInt(bytes.length);
        out.write(bytes);
      } else if (type == Short.TYPE) {
        short[] shorts = (short[]) obj;
        out.writeInt(shorts.length);
        for (short aShort : shorts) {
          out.writeShort(aShort);
        }
      } else if (type == Integer.TYPE) {
        int[] ints = (int[]) obj;
        out.writeInt(ints.length);
        for (int anInt : ints) {
          out.writeInt(anInt);
        }
      } else if (type == Long.TYPE) {
        long[] longs = (long[]) obj;
        out.writeInt(longs.length);
        for (long along : longs) {
          out.writeLong(along);
        }
      } else if (type == Float.TYPE) {
        float[] floats = (float[]) obj;
        out.writeInt(floats.length);
        for (float aFloat : floats) {
          out.writeFloat(aFloat);
        }
      } else if (type == Double.TYPE) {
        double[] doubles = (double[]) obj;
        out.writeInt(doubles.length);
        for (double aDouble : doubles) {
          out.writeDouble(aDouble);
        }
      } else if (type == Character.TYPE) {
        char[] chars = (char[]) obj;
        out.writeInt(chars.length);
        out.writeChars(String.valueOf(chars));
      } else if (type == Boolean.TYPE) {
        boolean[] booleans = (boolean[]) obj;
        out.writeInt(booleans.length);
        for (boolean aBoolean : booleans) {
          out.writeBoolean(aBoolean);
        }
      } else {
        throw new InternalError();
      }
    } else {
      Object[] objects = (Object[]) obj;
      out.writeInt(objects.length);
      for (Object o : objects) {
        new ObjectSerializerImpl().serialize(out, o);
      }
    }
  }
  
  @Override
  public Object deserialize(DataInputStream in) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
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
        objects[i] = new ObjectSerializerImpl().deserialize(in);
      }
      array = objects;
    }
    return array;
  }
}
