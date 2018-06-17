import java.util.Collections;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:20 ч.
 */
public class _005Greeting {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String firstName = console.nextLine();
        String lastName = console.nextLine();

        if (firstName.isEmpty()) {
            firstName = String.join("",
                    Collections.nCopies(5, "*"));
        }

        if (lastName.isEmpty()) {
            lastName = String.join("",
                    Collections.nCopies(5, "*"));
        }

        System.out.printf("Hello, %s %s!%n",firstName,lastName);
    }
}