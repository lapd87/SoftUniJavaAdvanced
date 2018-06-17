import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:58 ч.
 */
public class _12BalancedParentheses {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        char[] input = console.nextLine()
                .toCharArray();

        ArrayDeque<Character> openParenthesesStack = new ArrayDeque<>();

        boolean isClosing = true;

        for (char c : input) {
            if (!isClosing) {
                break;
            }

            if (c == '(' || c == '[' || c == '{') {
                openParenthesesStack.push(c);
            } else {

                if (openParenthesesStack.isEmpty()) {
                    isClosing = false;
                    break;
                }

                switch (c) {
                    case ')':
                        if (openParenthesesStack.pop() != '(') {
                            isClosing = false;
                        }
                        break;
                    case ']':
                        if (openParenthesesStack.pop() != '[') {
                            isClosing = false;
                        }
                        break;
                    case '}':
                        if (openParenthesesStack.pop() != '{') {
                            isClosing = false;
                        }
                        break;
                }
            }
        }
        if (isClosing) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}