import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:56 ч.
 */
public class _03DiagonalDifference {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int matrixSize = Integer.parseInt(console.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {

            int[] rowValues = Arrays
                    .stream(console.nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = rowValues[col];
            }
        }

        int primaryDiagonalSum = 0;
        for (int i = 0; i < matrixSize; i++) {
            primaryDiagonalSum += matrix[i][i];
        }

        int secondaryDiagonalSum = 0;
        for (int col = matrixSize - 1, row = 0;
             row < matrixSize && col >= 0;
             col--, row++) {
            secondaryDiagonalSum += matrix[row][col];
        }

        int difference = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);

        System.out.println(difference);
    }
}