import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:33 ч.
 */
public class _004SeriesOfLetters {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        input = input
                .replaceAll("(.)\\1+","$1");

        System.out.println(input);
    }
}