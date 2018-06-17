import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:57 ч.
 */
public class _08BasicStackOperations {
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

        int push = inputArgs[0];
        int pop = inputArgs[1];
        int check = inputArgs[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < push; i++) {
            stack.push(data[i]);
        }

        for (int i = 0; i < pop; i++) {
            stack.pop();
        }

        if (stack.contains(check)) {
            System.out.println(true);
        } else if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            int min = Integer.MAX_VALUE;

            while (!stack.isEmpty()) {
                int currentNum = stack.pop();
                if (currentNum < min) {
                    min = currentNum;
                }
            }

            System.out.println(min);
        }
    }
}