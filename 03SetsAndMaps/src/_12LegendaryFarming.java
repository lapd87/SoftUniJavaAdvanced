import java.lang.management.GarbageCollectorMXBean;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:48 ч.
 */
public class _12LegendaryFarming {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Map<String, Integer> farming = new TreeMap<>();

        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        keyMaterials.put("shards", 0);

        String legendaryName = "";
        boolean foundLegendary = false;

        while (!foundLegendary) {

            String[] input = console.nextLine()
                    .split("\\s+");

            for (int i = 0; i < input.length - 1; i += 2) {

                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();

                if (keyMaterials.containsKey(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                } else {
                    farming.putIfAbsent(material, 0);
                    farming.put(material, farming.get(material) + quantity);
                }

                if (keyMaterials.containsKey(material)
                        && keyMaterials.get(material) >= 250) {
                    switch (material) {
                        case "shards":
                            legendaryName = "Shadowmourne obtained!";
                            break;
                        case "fragments":
                            legendaryName = "Valanyr obtained!";
                            break;
                        case "motes":
                            legendaryName = "Dragonwrath obtained!";
                            break;
                    }

                    foundLegendary = true;
                    keyMaterials.put(material, keyMaterials.get(material) - 250);
                    break;
                }
            }
        }

        System.out.println(legendaryName);

        Map<String, Integer> sortedKeyMaterials = keyMaterials.entrySet()
                .stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (a, b) -> a, LinkedHashMap::new));

        for (Map.Entry<String, Integer> entry : sortedKeyMaterials.entrySet()) {
            System.out.println(entry.getKey() + ": "
                    + entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : farming.entrySet()) {
            System.out.println(entry.getKey() + ": "
                    + entry.getValue());
        }
    }
}