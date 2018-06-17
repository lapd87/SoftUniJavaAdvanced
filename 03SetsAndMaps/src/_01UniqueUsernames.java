import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:45 ч.
 */
public class _01UniqueUsernames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        Set<String> usernames= new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            usernames.add(console.nextLine());
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}