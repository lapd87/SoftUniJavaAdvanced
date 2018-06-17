import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:54 ч.
 */
public class _005FilterByAge {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        Map<String, Integer> nameAge = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] input = console.nextLine()
                    .split(", ");

            nameAge.putIfAbsent(input[0], Integer.parseInt(input[1]));
        }

        String condition = console.nextLine();
        int age = Integer.parseInt(console.nextLine());
        String format = console.nextLine();

        Predicate<Map.Entry<String, Integer>> ageCondition;

        if ("younger".equals(condition)) {
            ageCondition = e -> e.getValue() < age;
        } else {
            ageCondition = e -> e.getValue() >= age;
        }

        Consumer<Map.Entry<String, Integer>> print;
        if ("name".equals(format)) {
            print = name -> System.out.printf("%s%n", name.getKey());
        } else if ("age".equals(format)) {
            print = name -> System.out.printf("%d%n", name.getValue());
        } else {
            print = name -> System.out.printf("%s - %d%n", name.getKey(), name.getValue());
        }

        nameAge.entrySet().stream().filter(ageCondition).forEach(print);
    }
}