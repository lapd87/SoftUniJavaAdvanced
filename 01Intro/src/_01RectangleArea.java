import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:22 ч.
 */
public class _01RectangleArea {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        BigDecimal sideA = new BigDecimal(console.next());
        BigDecimal sideB = new BigDecimal(console.next());

        BigDecimal area = sideA.multiply(sideB);

        System.out.printf("%.2f", area);

    }

}