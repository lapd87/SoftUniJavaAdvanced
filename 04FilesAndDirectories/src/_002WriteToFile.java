import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:23 ч.
 */
public class _002WriteToFile {
    public static void main(String[] args) {

        String path = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String inputPath = path + "input.txt";
        String ouputPath = path + "output.txt";

        List<Character> punctuation = new ArrayList<>();
        Collections.addAll(punctuation, ',', '.', '!', '?');

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             FileOutputStream fileOutputStream = new FileOutputStream(ouputPath)) {
            int oneByte = fileInputStream.read();

            while (oneByte >= 0) {

                if (!punctuation.contains((char)oneByte)) {
                    fileOutputStream.write(oneByte);
                }

                oneByte = fileInputStream.read();
            }
        } catch (
                IOException e)

        {
            e.printStackTrace();
        }
    }
}