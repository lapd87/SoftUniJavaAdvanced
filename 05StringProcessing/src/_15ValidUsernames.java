import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:37 ч.
 */
public class _15ValidUsernames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] usernames = console.nextLine()
                .split(" |\\\\|/|\\(|\\)");

        List<String> validUsernames = new ArrayList<>();

        String regex = "^[A-Za-z][A-Za-z0-9_]{2,24}$";

        for (String username : usernames) {
            if (username.matches(regex)) {
                validUsernames.add(username);
            }
        }

        int maxLengthSum = 0;
        int maxIndex = 0;

        for (int i = 0; i < validUsernames.size() - 1; i++) {

            int firstLength = validUsernames.get(i).length();
            int secondLength = validUsernames.get(i + 1).length();

            int sum = firstLength + secondLength;

            if (sum > maxLengthSum) {
                maxIndex = i;
                maxLengthSum = sum;
            }
        }

        System.out.println(validUsernames.get(maxIndex));
        System.out.println(validUsernames.get(maxIndex + 1));
    }
}