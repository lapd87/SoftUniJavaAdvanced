import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:33 ч.
 */
public class _005VowelCount {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        Pattern pattern = Pattern.compile("[AEIOUYaeiouy]");
        Matcher matcher = pattern.matcher(input);

        int vowelCounter = 0;

        while (matcher.find()) {
            vowelCounter++;
        }

        System.out.println("Vowels: " + vowelCounter);
    }
}