import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:33 ч.
 */
public class _007ValidUsernames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input;

        Pattern pattern = Pattern.compile("^[A-Za-z0-9\\-_]{3,16}$");

        StringBuilder stringBuilder = new StringBuilder();

        boolean isFound = false;
        while (!"END".equals(input = console.nextLine())) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                isFound = true;
                stringBuilder.append("valid");
                stringBuilder.append(System.lineSeparator());
            } else {
                stringBuilder.append("invalid");
                stringBuilder.append(System.lineSeparator());
            }
        }

        if (isFound){
            System.out.println(stringBuilder);
        }
    }
}