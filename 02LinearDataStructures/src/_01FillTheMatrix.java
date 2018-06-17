import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:55 ч.
 */
public class _01FillTheMatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split(", ");

        int matrixSize = Integer.parseInt(input[0]);
        String matrixFillType = input[1];

        int[][] matrix = new int[matrixSize][matrixSize];

        switch (matrixFillType) {
            case "A":
                matrix = fillMatrixA(matrixSize);
                break;
            case "B":
                matrix = fillMatrixB(matrixSize);
                break;
        }

        printMatrix(matrix);

    }

    private static int[][] fillMatrixB(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        int currentNum = 1;
        for (int col = 0; col < matrixSize; col++) {
            for (int row = 0; row < matrixSize; row++) {
                if (col % 2 == 0) {
                    matrix[row][col] = currentNum;
                } else {
                    matrix[matrixSize - row - 1][col] = currentNum;
                }
                currentNum++;
            }
        }

        return matrix;
    }

    private static int[][] fillMatrixA(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        int currentNum = 1;
        for (int col = 0; col < matrixSize; col++) {
            for (int row = 0; row < matrixSize; row++) {
                matrix[row][col] = currentNum;
                currentNum++;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < matrix.length; j++) {
                row.append(matrix[i][j]).append(" ");
            }

            System.out.println(row.toString().trim());
        }
    }
}