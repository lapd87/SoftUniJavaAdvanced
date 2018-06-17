import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:57 ч.
 */
public class _07ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        long[] input = Arrays
                .stream(console.nextLine()
                        .split("\\s+"))
                .mapToLong(Long::parseLong)
                .toArray();

        ArrayDeque<Long> stack = new ArrayDeque<>();

        for (long num : input) {
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}