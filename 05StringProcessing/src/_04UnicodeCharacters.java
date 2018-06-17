import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:35 ч.
 */
public class _04UnicodeCharacters {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        for (char c : input.toCharArray()) {
            System.out.print("\\u" + Integer
                    .toHexString(c | 0x10000)
                    .substring(1));
        }

        System.out.println();
    }
}