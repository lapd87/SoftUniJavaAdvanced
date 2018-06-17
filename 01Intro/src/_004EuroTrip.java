import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:19 ч.
 */
public class _004EuroTrip {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double quantity = Double.parseDouble(console.nextLine());

        BigDecimal exchangeRate = new BigDecimal("4210500000000");

        BigDecimal priceInLv = new BigDecimal(quantity * 1.2);
        BigDecimal priceInMarks = exchangeRate.multiply(priceInLv);

        System.out.printf("%.2f marks%n", priceInMarks);
    }
}