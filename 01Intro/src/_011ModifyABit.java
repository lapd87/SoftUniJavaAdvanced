import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:21 ч.
 */
public class _011ModifyABit {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int num = console.nextInt();
        int position = console.nextInt();
        int bitValue = console.nextInt();

        int mask = 0;
        int result = 0;

        if (bitValue == 0) {
            mask = ~(1 << position);
            result = num & mask;
        } else {
            mask = 1 << position;
            result = num | mask;
        }

        System.out.println(result);
    }
}