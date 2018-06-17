import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:35 ч.
 */
public class _07LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split("\\s+");

        double result = 0;

        for (String s : input) {

            String number = s.substring(1, s.length() - 1);

            double num = Double.parseDouble(number);

            if (String.valueOf(s.charAt(0))
                    .matches("[A-Z]")) {
                num /= (s.charAt(0) - 64);
            } else {
                num *= (s.charAt(0) - 96);
            }

            if (String.valueOf(s.charAt(s.length() - 1))
                    .matches("[A-Z]")) {
                num -= (s.charAt(s.length() - 1) - 64);
            } else {
                num += (s.charAt(s.length() - 1) - 96);
            }

            result += num;
        }

        System.out.printf("%.2f%n", result);
    }
}