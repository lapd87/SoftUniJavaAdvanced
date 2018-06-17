import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:25 ч.
 */
public class _04CountCharacterTypes {
    public static void main(String[] args) {


        String resourcePath = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String inputPath = resourcePath + "ExercisesResources\\input.txt";

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(inputPath))) {

            List<Character> punctuation = new ArrayList<>();
            Collections.addAll(punctuation, ',', '.', '!', '?');

            List<Character> vowels = new ArrayList<>();
            Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');

            String line = bufferedReader.readLine();

            int vowelCount = 0;
            int consonantsCount = 0;
            int punctuationCount = 0;

            while (line != null) {

                for (char c : line.toCharArray()) {
                    if (vowels.contains(c)) {
                        vowelCount++;
                    } else if (punctuation.contains(c)) {
                        punctuationCount++;
                    } else if (' ' != c) {
                        consonantsCount++;
                    }
                }

                line = bufferedReader.readLine();
            }

            System.out.println("Vowels: " + vowelCount);
            System.out.println("Consonants: " + consonantsCount);
            System.out.println("Punctuation: " + punctuationCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}