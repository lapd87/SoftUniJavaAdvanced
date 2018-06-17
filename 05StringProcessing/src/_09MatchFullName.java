import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:36 ч.
 */
public class _09MatchFullName {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Pattern pattern = Pattern
                .compile("^([A-Z][a-z]+ [A-Z][a-z]+)*$");

        String input;
        while (!"end".equals(input=console.nextLine())){

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){
                System.out.println(input);
            }
        }
    }
}