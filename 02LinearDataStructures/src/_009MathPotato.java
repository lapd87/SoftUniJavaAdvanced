import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:55 ч.
 */
public class _009MathPotato {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] children = console.nextLine()
                .split("\\s+");

        int potato = Integer.parseInt(console.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue, children);

        int cycleCount = 1;

        while (queue.size() > 1) {
            for (int i = 1; i < potato; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycleCount)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }

            cycleCount++;
        }

        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cycleCount) {
        if (cycleCount < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(cycleCount); i++) {
            if (cycleCount % i == 0) {
                return false;
            }
        }

        return true;
    }
}