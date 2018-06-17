import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:24 ч.
 */
public class _07CharacterMultiplier {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split("\\s+", -1);

        String firstInput = input[0];
        String secondInput = input[1];

        int result = 0;

        int minLength = Math.min(firstInput.length(), secondInput.length());

        String substring;

        if (firstInput.length() >= secondInput.length()) {
            substring = firstInput.substring(minLength);
        } else {
            substring = secondInput.substring(minLength);
        }

        for (char c : substring.toCharArray()) {
            result += c;
        }

        for (int i = 0; i < minLength; i++) {
            result += firstInput.charAt(i) * secondInput.charAt(i);
        }

        System.out.println(result);
    }
}