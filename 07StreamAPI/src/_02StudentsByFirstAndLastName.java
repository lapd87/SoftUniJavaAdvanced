import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:29 ч.
 */
public class _02StudentsByFirstAndLastName {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<String> students = new ArrayList<>();

        while (true) {
            String[] input = console.nextLine()
                    .split("\\s+");

            if ("END".equals(input[0])) {
                break;
            }

            students.add(String.join(" ", input));
        }

        students.stream()
                .filter(s -> {
                    String[] name = s.split(" ");
                    String firstName = name[0];
                    String lastName = name[1];
                    return firstName.compareTo(lastName) < 0;
                })
                .forEach(System.out::println);
    }
}