import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:47 ч.
 */
public class _06MinerTask {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Map<String, Long> recources = new LinkedHashMap<>();

        String input;
        while (!"stop".equals(input = console.nextLine())) {

            Long quantity = Long.parseLong(console.nextLine());

            recources.putIfAbsent(input, 0L);
            recources.put(input, recources.get(input) + quantity);
        }

        for (Map.Entry<String, Long> entry : recources.entrySet()) {
            System.out.println(entry.getKey() + " -> "
                    + entry.getValue());
        }
    }
}