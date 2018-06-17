import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:29 ч.
 */
public class _04SortStudents {
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
                .sorted((s1, s2) -> {
                    String[] name1 = s1.split(" ");
                    String firstName1 = name1[0];
                    String lastName1 = name1[1];

                    String[] name2 = s2.split(" ");
                    String firstName2 = name2[0];
                    String lastName2 = name2[1];

                    if (lastName1.compareTo(lastName2) != 0) {
                        return lastName1.compareTo(lastName2);
                    } else {
                        return firstName2.compareTo(firstName1);
                    }
                })
                .forEach(System.out::println);
    }
}