import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:56 ч.
 */
public class _06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] command = console.nextLine()
                .split("[()]+");
        int rotation = Integer.parseInt(command[1]);

        while (rotation >= 360) {
            rotation -= 360;
        }

        List<String> matrixData = new ArrayList<>();

        int cols = 0;

        String input;
        while (!"END".equals(input = console.nextLine())) {
            matrixData.add(input);

            if (cols < input.length()) {
                cols = input.length();
            }
        }

        int rows = matrixData.size();

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {

            String matrixRow = matrixData.get(row);

            while (matrixRow.length() < cols) {
                matrixRow += " ";
            }

            char[] rowValues = matrixRow.toCharArray();

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Character
                        .toString(rowValues[col]);
            }
        }

        switch (rotation) {
            case 0:
                printMatrix0(matrix);
                break;
            case 90:
                printMatrix90(matrix);
                break;
            case 180:
                printMatrix180(matrix);
                break;
            case 270:
                printMatrix270(matrix);
                break;
        }
    }

    private static void printMatrix270(String[][] matrix) {
        for (int col = matrix[0].length - 1; col >= 0; col--) {
            StringBuilder rowValue = new StringBuilder();

            for (int row = 0; row < matrix.length; row++) {
                rowValue.append(matrix[row][col]);
            }

            System.out.println(rowValue.toString());

        }
    }

    private static void printMatrix90(String[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            StringBuilder rowValue = new StringBuilder();

            for (int row = matrix.length - 1; row >= 0; row--) {
                rowValue.append(matrix[row][col]);
            }

            System.out.println(rowValue.toString());
        }
    }

    private static void printMatrix180(String[][] matrix) {
        for (int row = matrix.length - 1; row >= 0; row--) {
            StringBuilder rowValue = new StringBuilder();

            for (int col = matrix[row].length - 1; col >= 0; col--) {
                rowValue.append(matrix[row][col]);
            }

            System.out.println(rowValue.toString());

        }
    }

    private static void printMatrix0(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            StringBuilder rowValue = new StringBuilder();

            for (int col = 0; col < matrix[row].length; col++) {
                rowValue.append(matrix[row][col]);
            }

            System.out.println(rowValue.toString());
        }
    }
}