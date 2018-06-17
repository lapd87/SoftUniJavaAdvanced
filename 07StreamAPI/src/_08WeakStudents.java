import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:30 ч.
 */
public class _08WeakStudents {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Map<String, List<Integer>> studentGrades = new LinkedHashMap<>();

        while (true) {
            String[] input = console.nextLine()
                    .split("\\s+");

            if ("END".equals(input[0])) {
                break;
            }

            String name = input[0] + " " + input[1];

            List<Integer> grades = new ArrayList<>();

            for (int i = 2; i < input.length; i++) {
                grades.add(Integer.parseInt(input[i]));
            }

            studentGrades.put(name, grades);
        }

        studentGrades.entrySet()
                .stream()
                .filter(s -> s.getValue()
                        .stream()
                        .filter(g -> g <= 3)
                        .count() >= 2)
                .forEach(s -> System.out.println(s.getKey()));
    }
}