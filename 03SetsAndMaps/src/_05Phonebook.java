import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:46 ч.
 */
public class _05Phonebook {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String input;
        while (!"search".equals(input = console.nextLine())) {
            String[] inputArgs = input.split("-");

            String name = inputArgs[0];
            String phoneNumber = inputArgs[1];

            phonebook.put(name, phoneNumber);
        }

        while (!"stop".equals(input = console.nextLine())) {

            if (phonebook.containsKey(input)) {
                System.out.println(input + " -> "
                        + phonebook.get(input));
            } else {
                System.out.println("Contact " + input
                        + " does not exist.");
            }
        }
    }
}