import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:22 ч.
 */
public class _010ExtractBitFromInteger {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int num = console.nextInt();
        int position = console.nextInt();

        int mask = num >> position;
        int bit = mask & 1;

        System.out.println(bit);

    }
}