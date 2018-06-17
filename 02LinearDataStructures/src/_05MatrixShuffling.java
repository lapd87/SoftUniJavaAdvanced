import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:56 ч.
 */
public class _05MatrixShuffling {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = console.nextInt();
        int cols = console.nextInt();
        console.nextLine();

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] rowValues = console.nextLine()
                    .split("\\s+");

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = rowValues[col];
            }
        }

        String input = "";
        while (!"END".equals(input = console.nextLine())) {

            String[] commandArgs = input.split("\\s+");

            if (!"swap".equals(commandArgs[0])
                    || commandArgs.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }

            int row1;
            int col1;
            int row2;
            int col2;

            try {
                row1 = Integer.parseInt(commandArgs[1]);
                col1 = Integer.parseInt(commandArgs[2]);
                row2 = Integer.parseInt(commandArgs[3]);
                col2 = Integer.parseInt(commandArgs[4]);
            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }

            if (row1 >= rows || col1 >= cols
                    || row2 >= rows || col2 >= cols) {
                System.out.println("Invalid input!");
                continue;
            }

            String temp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = temp;

            printMatrix(matrix);
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < matrix[i].length; j++) {
                row.append(matrix[i][j]).append(" ");
            }

            System.out.println(row.toString().trim());
        }
    }
}