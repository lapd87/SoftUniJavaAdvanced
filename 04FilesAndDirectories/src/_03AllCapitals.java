import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:25 ч.
 */
public class _03AllCapitals {
    public static void main(String[] args) {

        String resourcePath = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String inputPath = resourcePath + "ExercisesResources\\input.txt";
        String ouputPath = resourcePath + "ExercisesResources\\output.txt";

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(ouputPath)) {

            String line = bufferedReader.readLine();

            while (line != null) {

                line = line.toUpperCase();
                writer.write(line);
                writer.write(System.lineSeparator());

                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}