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
public class _10BasicQueueOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] inputArgs = Arrays
                .stream(console.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] data = Arrays
                .stream(console.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int enqueue = inputArgs[0];
        int dequeue = inputArgs[1];
        int check = inputArgs[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < enqueue; i++) {
            queue.add(data[i]);
        }

        for (int i = 0; i < dequeue; i++) {
            queue.remove();
        }

        if (queue.contains(check)) {
            System.out.println(true);
        } else if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}