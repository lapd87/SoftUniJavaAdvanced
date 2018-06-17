import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:45 ч.
 */
public class _02SetsOfElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] setSizes = console.nextLine()
                .split("\\s+");

        int firstSetSize = Integer.parseInt(setSizes[0]);
        int secondSetSize = Integer.parseInt(setSizes[1]);

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(console.nextLine());
        }

        for (int i = 0; i < secondSetSize; i++) {
            secondSet.add(console.nextLine());
        }

        StringBuilder result = new StringBuilder();
        for (String s : firstSet) {
            if (secondSet.contains(s)) {
                result.append(s).append(" ");
            }
        }

        System.out.println(result);
    }
}