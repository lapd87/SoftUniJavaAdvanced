import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:20 ч.
 */
public class _006TransportPrice {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double km = Double.parseDouble(console.nextLine());
        String timeOfDay = console.nextLine();

        double price = 0;

        if (km < 20) {

            switch (timeOfDay) {
                case "day":
                    price = km * 0.79 + 0.7;
                    break;
                case "night":
                    price = km * 0.9 + 0.7;
                    break;
            }
        } else if (km < 100) {
            price = km * 0.09;
        } else {
            price = km * 0.06;
        }

        System.out.printf("%.2f%n", price);
    }
}