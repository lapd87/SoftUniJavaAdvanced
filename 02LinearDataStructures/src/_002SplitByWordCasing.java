import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:53 ч.
 */
public class _002SplitByWordCasing {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<String> input = Arrays.asList(console.nextLine()
                .split("[,;:.!()\"'\\\\/\\[\\] ]+"));

        List<String> lowerCase = new ArrayList<>();
        List<String> upperCase = new ArrayList<>();
        List<String> mixedCase = new ArrayList<>();

        for (String word : input) {
            if (word.isEmpty()){
                continue;
            }

            if (word.matches("[a-z]+")) {
                lowerCase.add(word);
            } else if (word.matches("[A-Z]+")) {
                upperCase.add(word);
            } else {
                mixedCase.add(word);
            }
        }

        System.out.printf("Lower-case: %s%n",
                String.join(", ", lowerCase));
        System.out.printf("Mixed-case: %s%n",
                String.join(", ", mixedCase));
        System.out.printf("Upper-case: %s%n",
                String.join(", ", upperCase));

    }
}