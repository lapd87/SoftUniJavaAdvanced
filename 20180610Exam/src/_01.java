import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 9.6.2018 г.
 * Time: 19:07 ч.
 */
public class _01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        int problemCount = Integer.parseInt(bufferedReader
                .readLine());

        int candidatesCount = Integer.parseInt(bufferedReader
                .readLine());

        ArrayDeque<String> problems = new ArrayDeque<>();
        ArrayDeque<String> candidates = new ArrayDeque<>();

        for (int i = 0; i < problemCount; i++) {
            problems.push(bufferedReader.readLine());
        }

        for (int i = 0; i < candidatesCount; i++) {
            String candidateName = bufferedReader.readLine();

            if (candidateName.matches("[A-Z][a-z]+ [A-Z][a-z]+")) {
                candidates.add(candidateName);
            }
        }

        while (!problems.isEmpty()) {

            String problem = problems.remove();
            String candidate = candidates.remove();

            int problemStrength = problem.chars().sum();
            int candidateStrength = candidate.chars().sum();

            if (candidateStrength > problemStrength) {
                candidates.add(candidate);
                System.out.printf("%s solved %s.%n",
                        candidate, problem);
            } else {
                problems.add(problem);
                System.out.printf("%s failed %s.%n",
                        candidate, problem);
            }

            if (candidates.size() == 1) {
                System.out.printf("%s gets the job!%n",
                        candidates.peek());
                return;
            }
        }

        System.out.println(String.join(", ", candidates));
    }
}