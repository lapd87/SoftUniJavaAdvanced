import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:25 ч.
 */
public class _02SumBytes {
    public static void main(String[] args) {

        String resourcePath = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String inputPath = resourcePath + "ExercisesResources\\input.txt";

        long asciiSum = 0;

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(inputPath))) {

            String line = bufferedReader.readLine();

            while (line != null) {

                for (char c : line.toCharArray()) {
                    asciiSum += c;
                }

                line = bufferedReader.readLine();
            }

            System.out.println(asciiSum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}