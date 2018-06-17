import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:19 ч.
 */
public class _002ReadInput {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String firstWord = console.next("\\w+");
        String secondWord = console.next("\\w+");

        int sum = 0;

        for (int i = 0; i < 3; i++) {
            sum += console.nextInt();
        }

        console.nextLine();

        String thirdWord = console.nextLine();

        System.out.printf("%s %s %s %d%n",
                firstWord,
                secondWord,
                thirdWord,
                sum);

    }
}