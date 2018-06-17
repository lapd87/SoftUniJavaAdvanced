import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:21 ч.
 */
public class _008ProductOfNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int firstNum = console.nextInt();
        int secondNum = console.nextInt();

        BigInteger product = BigInteger.ONE;
        for (int i = firstNum; i <= secondNum; i++) {
            product = product.multiply(BigInteger.valueOf(i));
        }

        System.out.printf("product[%d..%d] = %d",
                firstNum,
                secondNum,
                product);
    }
}