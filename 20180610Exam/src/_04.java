import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 9.6.2018 г.
 * Time: 19:07 ч.
 */
public class _04 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        Map<String, String> contests = new HashMap<>();

        Map<String, Map<String, Integer>> userContestPoints = new LinkedHashMap<>();

        String input;
        while (!"end of contests".equals(input = bufferedReader
                .readLine())) {

            String contestName = input.split(":")[0];
            String contestPass = input.split(":")[1];

            contests.put(contestName, contestPass);
        }

        while (!"end of submissions".equals(input = bufferedReader
                .readLine())) {

            String[] inputArgs = input.split("=>");

            String contestName = inputArgs[0];
            String contestPass = inputArgs[1];

            if (!contestPass.equals(contests.getOrDefault(contestName, ""))) {
                continue;
            }

            String username = inputArgs[2];
            int userPoints = Integer.parseInt(inputArgs[3]);

            userContestPoints.putIfAbsent(username, new LinkedHashMap<>());

            Map<String, Integer> contestPoints = userContestPoints.get(username);
            contestPoints.putIfAbsent(contestName, 0);
            contestPoints.put(contestName,
                    Math.max(contestPoints.get(contestName),
                            userPoints));

            userContestPoints.put(username, contestPoints);
        }

        userContestPoints.entrySet()
                .stream()
                .sorted((u1, u2) -> {
                    int u1Points = u1.getValue().values()
                            .stream()
                            .mapToInt(p -> p)
                            .sum();

                    int u2Points = u2.getValue().values()
                            .stream()
                            .mapToInt(p -> p)
                            .sum();
                    return Integer.compare(u2Points, u1Points);
                })
                .limit(1)
                .forEach(u -> {
                    int points = u.getValue().values()
                            .stream()
                            .mapToInt(p -> p)
                            .sum();

                    System.out.printf("Best candidate is %s with total %d points.%n",
                            u.getKey(), points);
                });

        System.out.println("Ranking:");

        userContestPoints.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(u -> {
                    System.out.println(u.getKey());

                    u.getValue().entrySet()
                            .stream()
                            .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                            .forEach(c -> System.out.printf("#  %s -> %d%n",
                                    c.getKey(), c.getValue()));
                });
    }
}