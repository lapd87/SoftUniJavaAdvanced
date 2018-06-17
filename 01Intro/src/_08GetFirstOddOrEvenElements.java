import java.rmi.server.RMIClassLoader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:24 ч.
 */
public class _08GetFirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] inputNums = Arrays
                .stream(console.nextLine()
                        .split("\\s+", -1))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] command = console.nextLine().split("\\s+", -1);

        int count = Integer.parseInt(command[1]);

        int remainder = 0;

        if ("odd".equals(command[2].toLowerCase())) {
            remainder = 1;
        }

        StringBuilder result = new StringBuilder();

        for (int inputNum : inputNums) {
            if (count == 0) {
                break;
            }

            if (Math.abs(inputNum) % 2 == remainder) {
                count--;
                result.append(inputNum).append(" ");
            }
        }

        System.out.println(result.toString().trim());
    }
}