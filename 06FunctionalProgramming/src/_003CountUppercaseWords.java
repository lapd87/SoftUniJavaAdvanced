import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:54 ч.
 */
public class _003CountUppercaseWords {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] text = console.nextLine()
                .split("\\s+");

        Predicate<String> upperCase = s -> s.charAt(0) == s.toUpperCase().charAt(0);

        List<String> upperCaseWords = new ArrayList<>();

        int count = 0;
        for (String s : text) {
            if (!s.isEmpty() && upperCase.test(s)) {
                count++;
                upperCaseWords.add(s);
            }
        }

        System.out.println(count);
        for (String upperCaseWord : upperCaseWords) {
            System.out.println(upperCaseWord);
        }
    }
}