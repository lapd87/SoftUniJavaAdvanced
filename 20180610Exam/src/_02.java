import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 9.6.2018 г.
 * Time: 19:07 ч.
 */
public class _02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        int screenLength = Integer.parseInt(bufferedReader.readLine());

        String[] moveCommands = bufferedReader.readLine()
                .split(", ");

        String[][] screen = new String[screenLength][screenLength];

        int snakeRowPosition = 0;
        int snakeColPosition = 0;
        int snakeMaxLength = 1;
        for (int row = 0; row < screenLength; row++) {

            String[] rowData = bufferedReader.readLine()
                    .split(" ");

            for (int col = 0; col < screenLength; col++) {

                if (rowData[col].equals("s")) {
                    snakeRowPosition = row;
                    snakeColPosition = col;
                    rowData[col] = "*";
                }

                if (rowData[col].equals("f")) {
                    snakeMaxLength++;
                }

                screen[row][col] = rowData[col];
            }
        }

        int snakeLength = 1;
        for (String command : moveCommands) {
            switch (command) {
                case "up":
                    snakeRowPosition--;
                    if (snakeRowPosition < 0) {
                        snakeRowPosition += screenLength;
                    }
                    break;
                case "down":
                    snakeRowPosition++;
                    if (snakeRowPosition >= screenLength) {
                        snakeRowPosition = 0;
                    }
                    break;
                case "left":
                    snakeColPosition--;
                    if (snakeColPosition < 0) {
                        snakeColPosition += screenLength;
                    }
                    break;
                case "right":
                    snakeColPosition++;
                    if (snakeColPosition >= screenLength) {
                        snakeColPosition = 0;
                    }
                    break;
            }

            String screenValue = screen[snakeRowPosition][snakeColPosition];

            switch (screenValue) {
                case "f":
                    snakeLength++;
                    break;
                case "e":
                    System.out.println("You lose! Killed by an enemy!");
                    return;
            }

            if (snakeLength == snakeMaxLength) {
                break;
            }
        }

        if (snakeMaxLength > snakeLength) {
            System.out.printf("You lose! There is still %d food to be eaten.",
                    snakeMaxLength - snakeLength);
        } else {
            System.out.printf("You win! Final snake length is %d",
                    snakeLength);
        }
    }
}