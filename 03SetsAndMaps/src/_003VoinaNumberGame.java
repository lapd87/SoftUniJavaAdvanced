import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:44 ч.
 */
public class _003VoinaNumberGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] firstPlayerCards = Arrays
                .stream(console.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondPlayerCards = Arrays
                .stream(console.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        for (int i = 0; i < 20; i++) {
            firstPlayer.add(firstPlayerCards[i]);
            secondPlayer.add(secondPlayerCards[i]);
        }

        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty()
                    || secondPlayer.isEmpty()) {
                break;
            }

            int firstPlayerCard = firstPlayer.iterator().next();
            firstPlayer.remove(firstPlayerCard);
            int secondPlayerCard = secondPlayer.iterator().next();
            secondPlayer.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayer.add(firstPlayerCard);
                firstPlayer.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayer.add(firstPlayerCard);
                secondPlayer.add(secondPlayerCard);
            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}