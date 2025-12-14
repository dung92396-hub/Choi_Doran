package Java_set;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void join(String src, String out) throws IOException {
        File folder = new File(src);

        File[] files = folder.listFiles();

        FileOutputStream fos = new FileOutputStream(out);

        if (files != null) {
            Arrays.stream(files).forEach(f -> {
                byte[] buffer = new byte[1024];
                int byteRead;
                try {
                    FileInputStream fis = new FileInputStream(f);

                    while ((byteRead = fis.read(buffer)) != -1) {
                        fos.write(buffer, 0, byteRead);
                    }

                    fis.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        fos.close();
    }


    public static void main(String[] args) {
        try {
            join("C:\\Users\\Admin\\Documents\\test", "C:\\Users\\Admin\\Documents\\test-java\\src\\main\\java\\Java_set\\test\\joined.pdf");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
