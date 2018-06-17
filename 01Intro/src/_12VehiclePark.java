import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:25 ч.
 */
public class _12VehiclePark {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<String> vehiclePark = new ArrayList<>(Arrays
                .asList(console
                        .nextLine()
                        .split("\\s+", -1)));

        int soldCount = 0;

        String command;
        while (true) {
            if ("End of customers!"
                    .equals(command = console.nextLine())) {
                System.out.printf("Vehicles left: %s%n",
                        String.join(", ", vehiclePark));
                System.out.printf("Vehicles sold: %d%n",
                        soldCount);
                break;
            }

            String[] commandArgs = command
                    .toLowerCase()
                    .split("\\s+", -1);

            char vehicleType = commandArgs[0].charAt(0);
            int vehicleSeats = Integer.parseInt(commandArgs[2]);

            String desiredVehicle = "" + vehicleType + vehicleSeats;

            if (vehiclePark.contains(desiredVehicle)) {
                System.out.printf("Yes, sold for %d$%n",
                        vehicleType * vehicleSeats);
                vehiclePark.remove(desiredVehicle);
                soldCount++;
            } else {
                System.out.println("No");
            }
        }
    }
}