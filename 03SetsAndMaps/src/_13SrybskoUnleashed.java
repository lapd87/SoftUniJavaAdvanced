import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:49 ч.
 */
public class _13SrybskoUnleashed {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Map<String, Map<String, Long>> concerts = new LinkedHashMap<>();

        String input;
        while (!"End".equals(input = console.nextLine())) {
            try {
                String[] nameVenueTickets = input.split(" @");

                String singerName = nameVenueTickets[0];

                if (singerName.split("\\s+").length > 3
                        || singerName.split("\\s+").length < 1) {
                    continue;
                }

                String[] venuePriceCount = nameVenueTickets[1].split("\\s+");

                String venue = "";
                for (int i = 0; i < venuePriceCount.length - 2; i++) {
                    venue += venuePriceCount[i] + " ";
                }
                venue = venue.trim();

                if (venue.split("\\s+").length > 3
                        || venue.split("\\s+").length < 1) {
                    continue;
                }


                int ticketPrice = Integer
                        .parseInt(venuePriceCount[venuePriceCount
                                .length - 2]);
                int ticketCount = Integer
                        .parseInt(venuePriceCount[venuePriceCount
                                .length - 1]);

                int revenue = ticketPrice * ticketCount;

                concerts.putIfAbsent(venue, new LinkedHashMap<>());

                Map<String, Long> singerMoney = concerts.get(venue);
                singerMoney.putIfAbsent(singerName, 0L);
                singerMoney.put(singerName, singerMoney.get(singerName) + revenue);

                concerts.put(venue, singerMoney);

            } catch (Exception e) {
                continue;
            }
        }

        for (Map.Entry<String, Map<String, Long>> venue : concerts.entrySet()) {
            System.out.println(venue.getKey());

            Map<String, Long> sortedSingers = venue.getValue()
                    .entrySet()
                    .stream()
                    .sorted(Collections
                            .reverseOrder(Map.Entry
                                    .comparingByValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey,
                            Map.Entry::getValue,
                            (a, b) -> a,
                            LinkedHashMap::new));

            for (Map.Entry<String, Long> singer : sortedSingers.entrySet()) {
                System.out.printf("#  %s -> %d%n",
                        singer.getKey(),
                        singer.getValue());
            }
        }
    }
}