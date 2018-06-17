import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:55 ч.
 */
public class _02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split("\\s+");

        int rowSize = Integer.parseInt(input[0]);
        int colSize = Integer.parseInt(input[1]);

        String[][] matrix = new String[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            StringBuilder rowValue = new StringBuilder();

            for (int col = 0; col < colSize; col++) {
                char middle = (char) ('a' + row + col);
                char firstLast = (char) ('a' + row);

                String currentValue = "" + firstLast
                        + middle + firstLast;

                matrix[row][col] = currentValue;

                rowValue.append(currentValue).append(" ");
            }

            System.out.println(rowValue.toString().trim());
        }
    }
}