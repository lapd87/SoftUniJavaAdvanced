import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:56 ч.
 */
public class _08FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] input = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Consumer<int[]> minElement = nums -> {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (min >= nums[i]) {
                    min = nums[i];
                    index = i;
                }
            }

            System.out.println(index);
        };

        minElement.accept(input);
    }
}