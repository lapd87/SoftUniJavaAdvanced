import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.6.2018 г.
 * Time: 12:56 ч.
 */
public class _09CustomComparator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] input = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> nums = new ArrayList<>();

        for (int num : input) {
            nums.add(num);
        }

        Comparator<Integer> oddEvenAsc = (a, b) -> {
            if ((a % 2 == 0) == (b % 2 == 0)) {
                return a.compareTo(b);
            } else if (a % 2 == 0) {
                return -1;
            } else {
                return 1;
            }
        };

        nums.sort(oddEvenAsc);

        System.out.println(nums.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .trim());
    }
}