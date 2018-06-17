import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:59 ч.
 */
public class _15InfixToPostfix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split("\\s+");

        ArrayDeque<String> operatorStack = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            String currentToken = input[i];

            if (currentToken.matches("\\d+")) {
                output.append(currentToken)
                        .append(" ");
            } else if (currentToken.matches("[a-z]+")) {
                operatorStack.push(currentToken);
            } else if (currentToken.matches("[+\\-*/]")) {

                String stackTopOperator;
                while (!operatorStack.isEmpty()
                        && ((stackTopOperator = operatorStack.peek()).matches("[a-z]+")
                        || hasGreaterPrecedenceOrEqualAndLeft(currentToken, stackTopOperator))
                        && !"(".equals(stackTopOperator)) {

                    output.append(operatorStack.pop())
                            .append(" ");
                }

                operatorStack.push(currentToken);
            } else if ("(".equals(currentToken)) {
                operatorStack.push(currentToken);
            } else if (")".equals(currentToken)) {

                String stackTopOperator;

                while (!"(".equals(stackTopOperator = operatorStack.peek())) {
                    output.append(operatorStack.pop())
                            .append(" ");
                }

                operatorStack.pop();
            }
        }

        while (!operatorStack.isEmpty()) {
            output.append(operatorStack.pop())
                    .append(" ");
        }

        output.setLength(output.length() - 1);
        System.out.println(output);
    }

    private static boolean hasGreaterPrecedenceOrEqualAndLeft(String currentToken, String peek) {

        switch (currentToken) {
            case "+":
            case "-":
                return true;
            case "*":
                return "/".equals(peek);
            case "/":
                return "*".equals(peek);
            case "(":
                return true;
            default:
                return false;
        }
    }
}