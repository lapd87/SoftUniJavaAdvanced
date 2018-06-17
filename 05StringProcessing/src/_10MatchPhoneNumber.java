import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:36 ч.
 */
public class _10MatchPhoneNumber {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String regex = "^\\+359( |-)2(\\1)[\\d]{3}(\\1)[\\d]{4}$";

        String input;
        while (!"end".equals(input = console.nextLine())) {

            if (Pattern.matches(regex, input)) {
                System.out.println(input);
            }
        }
    }
}