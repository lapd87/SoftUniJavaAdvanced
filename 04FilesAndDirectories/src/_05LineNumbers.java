import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:25 ч.
 */
public class _05LineNumbers {
    public static void main(String[] args) {


        String resourcePath = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String inputPath = resourcePath + "\\ExercisesResources\\inputLineNumbers.txt";
        String ouputPath = resourcePath + "\\ExercisesResources\\ouputLineNumbers.txt";

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(ouputPath)) {

            String line = bufferedReader.readLine();

            int lineCount = 1;
            while (line != null) {

                writer.write(lineCount + ". ");
                writer.write(line);
                writer.write(System.lineSeparator());

                line = bufferedReader.readLine();
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}