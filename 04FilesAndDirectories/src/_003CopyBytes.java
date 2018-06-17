import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:23 ч.
 */
public class _003CopyBytes {
    public static void main(String[] args) {

        String path = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String inputPath = path + "input.txt";
        String ouputPath = path + "outputASCII.txt";

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             FileOutputStream fileOutputStream = new FileOutputStream(ouputPath)) {
            int oneByte = fileInputStream.read();

            while (oneByte >= 0) {
                if (oneByte != 10
                        && oneByte != 32) {//new line or space
                    String ascii = String.valueOf(oneByte);

                    for (int i = 0; i < ascii.length(); i++) {
                        fileOutputStream.write(ascii.charAt(i));
                    }
                } else {
                    fileOutputStream.write(oneByte);
                }

                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}