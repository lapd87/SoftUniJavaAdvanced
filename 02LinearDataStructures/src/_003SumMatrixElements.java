import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:53 ч.
 */
public class _003SumMatrixElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] rowsCols = console.nextLine()
                .split(", ");

        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);

        int[][] matrix = new int[rows][cols];
        int sum = 0;

        for (int i = 0; i < rows; i++) {
            String[] rowInput = console.nextLine()
                    .split(", ");

            for (int j = 0; j < cols; j++) {
                int num = Integer.parseInt(rowInput[j]);
                matrix[i][j] = num;
                sum += num;
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}