import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:53 ч.
 */
public class _004MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] rowsCols = console.nextLine()
                .split(", ");

        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] rowInput = console.nextLine()
                    .split(", ");

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(rowInput[j]);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        String maxSumRow1 = "";
        String maxSumRow2 = "";

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int sum = matrix[i][j] + matrix[i][j + 1]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1];

                if (sum > maxSum) {
                    maxSum = sum;
                    maxSumRow1 = matrix[i][j] + " "
                            + matrix[i][j + 1];
                    maxSumRow2 = matrix[i + 1][j] + " "
                            + matrix[i + 1][j + 1];
                }
            }
        }

        System.out.println(maxSumRow1);
        System.out.println(maxSumRow2);
        System.out.println(maxSum);
    }
}