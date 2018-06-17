import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:44 ч.
 */
public class _004CountSameValuesInArray {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split("\\s+");

        Map<String, Integer> counter = new HashMap<>();

        for (String s : input) {
            counter.putIfAbsent(s, 0);
            counter.put(s, counter.get(s) + 1);
        }

        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            System.out.println(entry.getKey() + " - "
                    + entry.getValue() + " times");
        }
    }
}