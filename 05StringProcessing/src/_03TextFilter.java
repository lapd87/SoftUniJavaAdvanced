import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:34 ч.
 */
public class _03TextFilter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] banned = console.nextLine()
                .split(", ");

        String text = console.nextLine();

        for (String s : banned) {

            int startIndex = text.indexOf(s);
            String replacement = String
                    .join("", Collections
                            .nCopies(s.length(), "*"));

            text = text.replaceAll(s, replacement);
        }

        System.out.println(text);
    }
}