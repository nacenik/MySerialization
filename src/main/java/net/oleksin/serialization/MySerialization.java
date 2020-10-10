package net.oleksin.serialization;

import java.io.*;

public interface MySerialization {
  void serializeObject(Object obj, String name) throws IOException;
  void deserializeObject(Object obj, String name) throws IOException;
}
