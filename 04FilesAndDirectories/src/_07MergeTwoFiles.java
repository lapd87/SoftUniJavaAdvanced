import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:26 ч.
 */
public class _07MergeTwoFiles {
    public static void main(String[] args) {

        String resourcePath = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String input1Path = resourcePath + "\\ExercisesResources\\inputOne.txt";
        String input2Path = resourcePath + "\\ExercisesResources\\inputTwo.txt";
        String outputPath = resourcePath + "\\ExercisesResources\\ouptutOneTwo.txt";

        try (BufferedReader input1PathReader =
                     new BufferedReader(new FileReader(input1Path));
             BufferedReader input2PathReader =
                     new BufferedReader(new FileReader(input2Path));
             PrintWriter writer = new PrintWriter(outputPath)) {

            String line = input1PathReader.readLine();

            while (line != null) {

                writer.write(line);
                writer.write(System.lineSeparator());

                line = input1PathReader.readLine();
            }

            line = input2PathReader.readLine();

            while (line != null) {

                writer.write(line);
                writer.write(System.lineSeparator());

                line = input2PathReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}