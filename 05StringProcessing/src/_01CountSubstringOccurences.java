import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:34 ч.
 */
public class _01CountSubstringOccurences {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine().toLowerCase();

        String match = console.nextLine().toLowerCase();

        int count = 0;
        while (input.contains(match)) {
            int startIndex = input.indexOf(match) + 1;

            input = input.substring(startIndex);
            count++;
        }

        System.out.println(count);
    }
}