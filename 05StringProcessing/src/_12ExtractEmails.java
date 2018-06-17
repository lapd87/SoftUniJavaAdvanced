import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:36 ч.
 */
public class _12ExtractEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        Pattern pattern = Pattern.compile("(^| )[A-Za-z0-9][\\w\\.-]+[A-Za-z0-9]@[A-Za-z][A-Za-z-]+[A-Za-z]\\.[A-Za-z" +
                ".]+[A-Za-z]");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.println(matcher.group().trim());
        }
    }
}