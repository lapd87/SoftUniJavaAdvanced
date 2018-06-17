import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:29 ч.
 */
public class _01StudentsByGroup {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Map<String, Integer> studentsGroup = new LinkedHashMap<>();

        while (true) {
            String[] input = console.nextLine()
                    .split("\\s+");

            if ("END".equals(input[0])) {
                break;
            }

            studentsGroup.put(input[0] + " " + input[1],
                    Integer.parseInt(input[2]));
        }

        studentsGroup.entrySet()
                .stream()
                .filter(s -> s.getValue() == 2)
                .sorted((s1, s2) -> {
                    String f1 = s1.getKey().split(" ")[0];
                    String f2 = s2.getKey().split(" ")[0];
                    return f1.compareTo(f2);
                })
                .forEach(s -> System.out.println(s.getKey()));
    }
}