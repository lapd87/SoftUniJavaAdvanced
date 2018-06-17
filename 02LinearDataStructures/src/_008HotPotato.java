import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:54 ч.
 */
public class _008HotPotato {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] children = console.nextLine()
                .split("\\s+");

        int potato = Integer.parseInt(console.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue, children);

        while (queue.size() > 1) {
            for (int i = 1; i < potato; i++) {
                queue.offer(queue.poll());
            }

            System.out.println("Removed " + queue.poll());
        }

        System.out.println("Last is " + queue.poll());
    }
}