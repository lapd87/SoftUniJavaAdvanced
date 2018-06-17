import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:56 ч.
 */
public class _04MaximalSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = console.nextInt();
        int cols = console.nextInt();
        console.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] rowValues = Arrays
                    .stream(console.nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = rowValues[col];
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int maxRowIndex = 0;
        int maxColIndex = 0;


        for (int row = 0; row <= rows - 3; row++) {
            for (int col = 0; col <= cols - 3; col++) {
                int currentSum = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        currentSum += matrix[row + i][col + j];
                    }
                }

                if (maxSum < currentSum) {
                    maxSum = currentSum;
                    maxRowIndex = row;
                    maxColIndex = col;
                }
            }
        }

        System.out.println("Sum = " + maxSum);

        for (int i = maxRowIndex; i < maxRowIndex + 3; i++) {
            StringBuilder rowValue = new StringBuilder();
            for (int j = maxColIndex; j < maxColIndex + 3; j++) {
                rowValue.append(matrix[i][j]).append(" ");
            }
            System.out.println(rowValue.toString().trim());
        }
    }
}