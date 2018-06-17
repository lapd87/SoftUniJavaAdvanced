import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:43 ч.
 */
public class _001ParkingLot {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Set<String> parkingLot = new HashSet<>();

        String input;
        while (!"END".equals(input = console.nextLine())) {

            String[] commandArgs = input.split(", ");

            if ("IN".equals(commandArgs[0])) {
                parkingLot.add(commandArgs[1]);
            } else {
                parkingLot.remove(commandArgs[1]);
            }
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parkingLot) {
                System.out.println(car);
            }
        }
    }
}