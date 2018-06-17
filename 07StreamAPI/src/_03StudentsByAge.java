import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:29 ч.
 */
public class _03StudentsByAge {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Map<String, Integer> studentsAge = new LinkedHashMap<>();

        while (true) {
            String[] input = console.nextLine()
                    .split("\\s+");

            if ("END".equals(input[0])) {
                break;
            }

            studentsAge.put(input[0] + " " + input[1],
                    Integer.parseInt(input[2]));
        }

        studentsAge.entrySet()
                .stream()
                .filter(s -> s.getValue() >= 18
                        && s.getValue() <= 24)
                .forEach(s -> System.out.println(s.getKey()
                        + " " + s.getValue()));
    }
}