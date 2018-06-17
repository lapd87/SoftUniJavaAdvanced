import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:46 ч.
 */
public class _04CountSymbols {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        char[] input = console.nextLine().toCharArray();

        Map<Character, Integer> symbols = new TreeMap<>();

        for (char c : input) {
            symbols.putIfAbsent(c, 0);
            symbols.put(c, symbols.get(c) + 1);
        }

        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            System.out.printf("%s: %d time/s%n",
                    entry.getKey(), entry.getValue());
        }
    }
}