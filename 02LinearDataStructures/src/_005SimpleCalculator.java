import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:54 ч.
 */
public class _005SimpleCalculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, input);

        while (stack.size() > 1) {

            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            if ("+".equals(operator)) {
                stack.push(String.valueOf(firstNum + secondNum));
            } else {
                stack.push(String.valueOf(firstNum - secondNum));
            }
        }

        System.out.println(stack.peek());
    }
}