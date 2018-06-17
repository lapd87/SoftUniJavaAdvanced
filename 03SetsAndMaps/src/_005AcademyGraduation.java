import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:45 ч.
 */
public class _005AcademyGraduation {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        Map<String, Double> academyGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = console.nextLine();
            String[] grades = console.nextLine()
                    .split("\\s+");

            double average = 0;
            for (String grade : grades) {
                average += Double.parseDouble(grade);
            }
            average /= grades.length;

            academyGrades.put(name, average);
        }

        for (Map.Entry<String, Double> entry : academyGrades.entrySet()) {
            System.out.printf("%s is graduated with %s%n",
                    entry.getKey(), entry.getValue());
        }
    }
}