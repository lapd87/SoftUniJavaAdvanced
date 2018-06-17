import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:54 ч.
 */
public class _007MatchingBrackets {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else if (input.charAt(i) == ')') {
                int startIndex = stack.pop();

                String subexpression = input
                        .substring(startIndex, i + 1);

                System.out.println(subexpression);
            }
        }
    }
}