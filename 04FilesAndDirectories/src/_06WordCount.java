import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:25 ч.
 */
public class _06WordCount {
    public static void main(String[] args) {

        String resourcePath = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String inputPath = resourcePath + "\\ExercisesResources\\text.txt";
        String matchPath = resourcePath + "\\ExercisesResources\\words.txt";
        String outputPath = resourcePath + "\\ExercisesResources\\result.txt";

        Set<String> matchWords = new HashSet<>();
        Map<String, Integer> wordCount = new LinkedHashMap<>();

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(matchPath))) {

            String line = bufferedReader.readLine();

            while (line != null) {

                for (String word : line.split("\\s+")) {
                    matchWords.add(word);
                }

                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(inputPath))) {

            String line = bufferedReader.readLine();

            while (line != null) {

                for (String word : line.split("\\s+")) {
                    if (matchWords.contains(word)) {
                        wordCount.putIfAbsent(word, 0);
                        wordCount.put(word, wordCount.get(word) + 1);
                    }
                }

                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(outputPath)) {

            Map<String, Integer> sortedWordCount = wordCount.entrySet()
                    .stream()
                    .sorted(Collections
                            .reverseOrder(Map.Entry
                                    .comparingByValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey,
                            Map.Entry::getValue,
                            (a, b) -> a,
                            LinkedHashMap::new));

            for (Map.Entry<String, Integer> entry : sortedWordCount.entrySet()) {
                String resultLine = entry.getKey() + " - "
                        + entry.getValue();

                writer.write(resultLine);
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}