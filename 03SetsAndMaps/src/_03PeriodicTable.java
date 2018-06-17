import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:46 ч.
 */
public class _03PeriodicTable {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        Set<String> chemicals = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = console.nextLine()
                    .split("\\s+");

            chemicals.addAll(Arrays.asList(input));
        }

        for (String chemical : chemicals) {
            System.out.print(chemical + " ");
        }

        System.out.println();
    }
}