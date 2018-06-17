
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:36 ч.
 */
public class _08MelrahShake {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();
        String shake = console.nextLine();

        while (!shake.isEmpty() && input.contains(shake)) {

            String temp = input;
            int shakeCount = temp.length()
                    - temp.replace(shake, "").length();

            if (shakeCount < 2) {
                break;
            }

            input = input.replaceFirst(Pattern.quote(shake),
                    Matcher.quoteReplacement(""));


            int lastIndex = input.lastIndexOf(shake);
            input = input
                    .substring(0, lastIndex)
                    + input
                    .substring(lastIndex + shake.length());

            shake = shake
                    .substring(0, shake.length() / 2)
                    + shake
                    .substring(shake.length() / 2 + 1);

            System.out.println("Shaked it.");
        }

        System.out.println("No shake.");
        System.out.println(input);
    }
}