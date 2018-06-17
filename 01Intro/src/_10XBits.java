import java.util.Collections;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:24 ч.
 */
public class _10XBits {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        char[][] matrix = new char[8][32];

        for (int row = 0; row < 8; row++) {

            int number = Integer.parseInt(console.nextLine());

            String numberBits = String
                    .format("%32s", Integer
                            .toBinaryString(number))
                    .replace(' ', '0');

            for (int col = 0; col < 32; col++) {
                matrix[row][col] = numberBits.charAt(col);
            }
        }

        int xBitCount = 0;

        for (int row = 0; row < 8-2; row++) {
            for (int col = 0; col < 32-2; col++) {
                if (isXBit(matrix, row, col)) {
                    xBitCount++;
                }
            }
        }

        System.out.println(xBitCount);
    }

    private static boolean isXBit(char[][] matrix, int row, int col) {

        String xbit = "101010101";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (xbit.charAt(3 * i + j) != matrix[row + i][col + j]) {
                    return false;
                }
            }
        }

        return true;
    }
}