import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:47 ч.
 */
public class _07FixEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Map<String, String> emailBook = new LinkedHashMap<>();

        String input;
        while (!"stop".equals(input = console.nextLine())) {

            String email = console.nextLine();

            if (!email.endsWith("us")
                    && !email.endsWith("uk")
                    && !email.endsWith("com")) {

                emailBook.put(input, email);
            }
        }

        for (Map.Entry<String, String> entry : emailBook.entrySet()) {
            System.out.println(entry.getKey() + " -> "
                    + entry.getValue());
        }
    }
}