import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:34 ч.
 */
public class _02SumBigNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String firstNum = console.nextLine();
        String secondNum = console.nextLine();

        int firstNumLength = firstNum.length();
        int secondNumLength = secondNum.length();

        firstNum = String.format("%1$" + secondNumLength + "s",
                firstNum).replace(' ', '0');
        secondNum = String.format("%1$" + firstNumLength + "s",
                secondNum).replace(' ', '0');

        StringBuilder stringBuilder = new StringBuilder();

        int remainder = 0;
        for (int i = firstNum.length() - 1; i >= 0; i--) {
            int fNum = Integer.parseInt(String
                    .valueOf(firstNum.charAt(i)));
            int sNum = Integer.parseInt(String
                    .valueOf(secondNum.charAt(i)));

            int result = fNum + sNum + remainder;

            remainder = 0;
            if (result >= 10) {
                result -= 10;
                remainder++;
            }

            stringBuilder.append(result);
        }

        if (remainder == 1) {
            stringBuilder.append(remainder);
        }

        stringBuilder.reverse();

        while (stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }

        System.out.println(stringBuilder);
    }
}