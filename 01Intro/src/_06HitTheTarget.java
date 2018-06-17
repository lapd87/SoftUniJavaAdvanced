import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:23 ч.
 */
public class _06HitTheTarget {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int target = console.nextInt();

        List<String> addedResults = new ArrayList<>();
        List<String> negativeResults = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            if (target - i > 20) {
                continue;
            }
            for (int j = 1; j <= 20; j++) {
                if (i + j == target) {
                    addedResults.add(String.format("%d + %d = %d%n",
                            i, j, target));
                }
                if (i - j == target) {
                    negativeResults.add(String.format("%d - %d = %d%n",
                            i, j, target));
                }
            }
        }

        String result = String.join("", addedResults)
                + String.join("", negativeResults);

        System.out.print(result);
    }
}