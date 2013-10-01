package org.drizzle.adler;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class Adler32
{
    static {
      try {
        InputStream reader = Adler32.class.getResourceAsStream("libadler32.so");
        FileOutputStream  writer = new FileOutputStream("/tmp/libadler32.so");
        byte[] buffer = new byte[8192];
        int bytesRead = 0;
        while ((bytesRead = reader.read(buffer)) != -1) {
          writer.write(buffer, 0, bytesRead);
        }
        writer.close();
        reader.close();
        System.load("/tmp/libadler32.so");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }

    }
    public native void checksum(ByteBuffer data, int pos, int len, ByteBuffer checksum);
}