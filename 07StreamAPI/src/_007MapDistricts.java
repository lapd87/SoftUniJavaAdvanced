import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:28 ч.
 */
public class _007MapDistricts {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split("\\s+");

        int minPopulation = Integer.parseInt(console.nextLine());

        Map<String, List<Integer>> cityDistricts = new LinkedHashMap<>();

        Arrays.stream(input).forEach(s -> {
            String[] cityArgs = s.split(":");
            String cityName = cityArgs[0];
            int districtPopulation = Integer.parseInt(cityArgs[1]);

            cityDistricts.putIfAbsent(cityName, new ArrayList<>());
            cityDistricts.get(cityName).add(districtPopulation);
        });

        cityDistricts.entrySet()
                .stream()
                .filter(c -> {
                    int population = c.getValue()
                            .stream()
                            .mapToInt(Integer::intValue)
                            .sum();
                    return population > minPopulation;
                })
                .sorted((c1, c2) -> {
                    int population1 = c1.getValue()
                            .stream()
                            .mapToInt(Integer::intValue)
                            .sum();
                    int population2 = c2.getValue()
                            .stream()
                            .mapToInt(Integer::intValue)
                            .sum();
                    return Integer.compare(population2, population1);
                })
                .forEach(c -> {
                    System.out.print(c.getKey() + ": ");

                    c.getValue()
                            .stream()
                            .sorted(Comparator.reverseOrder())
                            .limit(5)
                            .forEach(d -> System.out.print(d + " "));

                    System.out.println();
                });
    }
}