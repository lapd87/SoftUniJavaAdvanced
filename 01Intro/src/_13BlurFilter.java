import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:25 ч.
 */
public class _13BlurFilter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        long blur = Long.parseLong(console.nextLine());

        String[] input = console.nextLine()
                .split("\\s+", -1);
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        long[][] matrix = new long[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] numbers = console.nextLine()
                    .split("\\s+", -1);

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Long.parseLong(numbers[col]);
            }
        }

        String[] command = console.nextLine()
                .split("\\s+", -1);

        int blurRow = Integer.parseInt(command[0]);
        int blurCol = Integer.parseInt(command[1]);

        for (int i = blurRow - 1; i <= blurRow + 1; i++) {
            if (i < 0 || i >= rows) {
                continue;
            }

            for (int j = blurCol - 1; j <= blurCol + 1; j++) {
                if (j < 0 || j >= cols) {
                    continue;
                }

                matrix[i][j] += blur;
            }
        }

        for (int i = 0; i < rows; i++) {
            String row = "";

            for (int j = 0; j < cols; j++) {
                row += matrix[i][j] + " ";
            }
            System.out.println(row.trim());
        }
    }
}