import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:21 ч.
 */
public class _009Lottery {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        for (int i = 1; i < 9; i++) {
            for (int j = i + 1; j < 10; j++) {
                for (int k = j + 1; k <= 10; k++) {
                    System.out.printf("%d %d %d%n", i, j, k);
                }
            }
        }
    }
}