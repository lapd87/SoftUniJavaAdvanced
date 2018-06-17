import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:36 ч.
 */
public class _11ReplaceTag {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String text = "";

        String input;
        while (!"END".equals(input = console.nextLine())) {
            text += input + System.lineSeparator();
        }

        while (true) {

            Pattern pattern = Pattern
                    .compile("<a\\s+href=[^>]+>\\s*.*?<\\/a>");

            Matcher matcher = pattern.matcher(text);

            if (!matcher.find()) {
                break;
            }

            String replacement = matcher.group()
                    .replaceFirst("<a", "[URL")
                    .replaceFirst(">", "]")
                    .replaceFirst("</a>", "[/URL]");

            text = text.replace(matcher.group(), replacement);
        }

        System.out.println(text);
    }
}