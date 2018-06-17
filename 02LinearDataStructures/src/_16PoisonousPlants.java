import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:59 ч.
 */
public class _16PoisonousPlants {
    public static void main(String[] args) throws IOException {

        // not working 100%
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int plantsCount = Integer.parseInt(bufferedReader.readLine());

        int[] plantGMO = Arrays
                .stream(bufferedReader.readLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        LinkedHashMap<Integer, Boolean> gardenAlive = new LinkedHashMap<>();

        for (int plant : plantGMO) {
            gardenAlive.put(plant, true);
        }

        boolean hasDied = true;
        int daysCount = 0;

        while (hasDied) {
            hasDied = false;

            int leftPlant = Integer.MAX_VALUE;

            for (Map.Entry<Integer, Boolean> plant : gardenAlive.entrySet()) {
                if (plant.getKey() > leftPlant) {
                    plant.setValue(false);
                    hasDied = true;
                }

                leftPlant = plant.getKey();
            }

            if (hasDied) {
                gardenAlive.values().removeIf(val -> !val);
                daysCount++;
            }
        }

        System.out.println(daysCount);
    }
}