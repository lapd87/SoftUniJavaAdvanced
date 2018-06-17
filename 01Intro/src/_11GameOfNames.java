import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:24 ч.
 */
public class _11GameOfNames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int playeerCount = Integer.parseInt(console.nextLine());

        String winnerName = "";
        int winnerScore = Integer.MIN_VALUE;

        for (int i = 0; i < playeerCount; i++) {

            String playerName = console.nextLine();
            int playerScore = Integer.parseInt(console.nextLine());

            for (char c : playerName.toCharArray()) {
                if (c % 2 == 0) {
                    playerScore += c;
                } else {
                    playerScore -= c;
                }
            }


            if (playerScore > winnerScore) {
                winnerName = playerName;
                winnerScore = playerScore;
            }
        }

        System.out.printf("The winner is %s - %d points",
                winnerName,
                winnerScore);

    }
}