import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:30 ч.
 */
public class _06FilterStudentsByPhone {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Map<String, String> studentPhones = new LinkedHashMap<>();

        while (true) {
            String[] input = console.nextLine()
                    .split("\\s+");

            if ("END".equals(input[0])) {
                break;
            }

            studentPhones.put(input[0] + " " + input[1],
                    input[2]);
        }

        studentPhones.entrySet()
                .stream()
                .filter(s -> s.getValue().startsWith("02")
                        || s.getValue().startsWith("+3592"))
                .forEach(s -> System.out.println(s.getKey()));
    }
}