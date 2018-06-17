import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:57 ч.
 */
public class _09MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int commandsCount = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> stack = new ArrayDeque<>(), maxStack = new ArrayDeque<>();

        StringBuilder result = new StringBuilder();

        int maxNum = 0;

        for (int i = 0; i < commandsCount; i++) {

            String[] commandArgs = bufferedReader.readLine()
                    .split(" ");

            String command = commandArgs[0];
            if ("1".equals(command)) {
                int num = Integer.parseInt(commandArgs[1]);

                stack.push(num);

                if (maxNum <= num) {
                    maxStack.push(num);
                    maxNum = num;
                }
            } else if ("2".equals(command)) {
                if (maxNum == stack.pop()) {
                    maxStack.pop();
                    if (maxStack.size() > 0) {
                        maxNum = maxStack.peek();
                    } else {
                        maxNum = 0;
                    }
                }
            } else {
                result.append(maxNum)
                        .append(System.lineSeparator());
            }
        }
        System.out.print(result);
    }
}