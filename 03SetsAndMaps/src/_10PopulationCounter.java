import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:48 ч.
 */
public class _10PopulationCounter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Map<String, Map<String, Long>> populationReport = new LinkedHashMap<>();

        String input;
        while (!"report".equals(input = console.nextLine())) {

            String[] inputArgs = input.split("\\|");

            String city = inputArgs[0];
            String country = inputArgs[1];
            Long population = Long.parseLong(inputArgs[2]);

            populationReport.putIfAbsent(country, new LinkedHashMap<>());

            Map<String, Long> cityPopulation = populationReport.get(country);
            cityPopulation.putIfAbsent(city, population);

            populationReport.put(country, cityPopulation);
        }


        Map<String, Map<String, Long>> sortedReport = populationReport
                .entrySet()
                .stream()
                .sorted((country1, country2) -> {
                    long populationCountry1 =
                            country1.getValue()
                                    .values()
                                    .stream()
                                    .mapToLong(Long::valueOf)
                                    .sum();
                    long populationCountry2 =
                            country2.getValue()
                                    .values()
                                    .stream()
                                    .mapToLong(Long::valueOf)
                                    .sum();
                    return Long.compare(populationCountry2, populationCountry1);
                })
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (a, b) -> a, LinkedHashMap::new));


        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Map<String, Long>> country : sortedReport.entrySet()) {

            Map<String, Long> sortedCities = country.getValue()
                    .entrySet()
                    .stream()
                    .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                    .collect(Collectors
                            .toMap(Map.Entry::getKey, Map.Entry::getValue,
                                    (a, b) -> a, LinkedHashMap::new));

            Long totalPopulation = 0L;

            StringBuilder citiesResult = new StringBuilder();
            for (Map.Entry<String, Long> city : sortedCities.entrySet()) {

                citiesResult.append("=>")
                        .append(city.getKey())
                        .append(": ")
                        .append(city.getValue())
                        .append(System.lineSeparator());

                totalPopulation += city.getValue();
            }

            result.append(country.getKey())
                    .append(" (total population: ")
                    .append(totalPopulation)
                    .append(")")
                    .append(System.lineSeparator())
                    .append(citiesResult);
        }

        System.out.println(result);
    }
}