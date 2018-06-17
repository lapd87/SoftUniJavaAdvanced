import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:28 ч.
 */
public class _006FindAndSumIntegers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] input = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .filter(s -> {
                    try {
                        Integer.parseInt(s);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(input.length != 0 ?
                Arrays.stream(input).sum() :
                "No match");
    }
}