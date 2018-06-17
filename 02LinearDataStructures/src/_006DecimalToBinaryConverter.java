import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:54 ч.
 */
public class _006DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int num = Integer.parseInt(console.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (num == 0) {
            System.out.println(num);
            return;
        }

        while (num > 0) {
            stack.push(num % 2);
            num /= 2;
        }

        while (stack.size() > 0) {
            System.out.print(stack.pop());
        }
    }
}