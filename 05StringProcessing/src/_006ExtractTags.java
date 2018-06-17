import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:33 ч.
 */
public class _006ExtractTags {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input;

        Pattern pattern = Pattern.compile("<.+?>");

        while (!"END".equals(input = console.nextLine())) {

            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }
}