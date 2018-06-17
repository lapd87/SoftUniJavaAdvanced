import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:25 ч.
 */
public class _01SumLines {
    public static void main(String[] args) {

        String resourcePath = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String inputPath = resourcePath + "ExercisesResources\\input.txt";


        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(inputPath))) {

            String line = bufferedReader.readLine();

            while (line != null) {
                int asciiSum = 0;

                for (char c : line.toCharArray()) {
                    asciiSum += c;
                }
                System.out.println(asciiSum);

                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}