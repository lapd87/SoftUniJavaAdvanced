import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:32 ч.
 */
public class _003ParseTags {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split("<upcase>|</upcase>");

        for (int i = 1; i < input.length-1; i+=2) {
            input[i] = input[i].toUpperCase();
        }

        for (String s : input) {
            System.out.print(s);
        }
        System.out.println();
    }
}