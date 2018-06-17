import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:58 ч.
 */
public class _13RecursiveFibonacci {
    private static long[] memo;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        memo = new long[n + 1];

        System.out.println(FibonacciWithMemorization(n));
    }

    private static long FibonacciWithMemorization(int n) {
        if (n <= 1) {
            return 1;
        } else if (memo[n] != 0) {
            return memo[n];
        } else {
            return memo[n] = FibonacciWithMemorization(n - 1)
                    + FibonacciWithMemorization(n - 2);
        }
    }
}
