import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:24 ч.
 */
public class _005WriteEveryThirdLine {
    public static void main(String[] args) {

        String path = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String inputPath = path + "input.txt";
        String ouputPath = path + "output3line.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(ouputPath)) {

            String line = bufferedReader.readLine();
            int count = 1;
            while (line != null) {
                if (count % 3 == 0) {
                    writer.println(line);
                }
                line = bufferedReader.readLine();
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}