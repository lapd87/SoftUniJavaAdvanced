import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:47 ч.
 */
public class _08HandsOfCards {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Map<String, Set<String>> players = new LinkedHashMap<>();

        String input;
        while (!"JOKER".equals(input = console.nextLine())) {

            String[] playerInput = input.split(": ");
            String playerName = playerInput[0];
            String[] playerCards = playerInput[1].split(", ");

            players.putIfAbsent(playerName, new HashSet<>());

            Set<String> currentCards = players.get(playerName);
            Collections.addAll(currentCards, playerCards);
            players.putIfAbsent(playerName, currentCards);
        }

        for (Map.Entry<String, Set<String>> entry : players.entrySet()) {

            int totalValue = 0;

            for (String card : entry.getValue()) {

                int stringLength = card.length();

                String power = card.substring(0, stringLength - 1);
                String type = card.substring(stringLength - 1);

                int powerValue;
                switch (power) {
                    case "J":
                        powerValue = 11;
                        break;
                    case "Q":
                        powerValue = 12;
                        break;
                    case "K":
                        powerValue = 13;
                        break;
                    case "A":
                        powerValue = 14;
                        break;
                    default:
                        powerValue = Integer.parseInt(power);
                }

                int typeValue;
                switch (type) {
                    case "S":
                        typeValue = 4;
                        break;
                    case "H":
                        typeValue = 3;
                        break;
                    case "D":
                        typeValue = 2;
                        break;
                    case "C":
                        typeValue = 1;
                        break;
                    default:
                        typeValue = 0;
                }

                totalValue += powerValue * typeValue;
            }

            System.out.println(entry.getKey() + ": " + totalValue);
        }
    }
}