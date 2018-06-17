import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:35 ч.
 */
public class _06MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split(" ");

        String firstWord = input[0];
        String secondWord = input[1];

        Set<Character> firstChars = new HashSet<>();
        Set<Character> secondChars = new HashSet<>();

        for (Character firstChar : firstWord.toCharArray()) {
            firstChars.add(firstChar);
        }

        for (Character secondChar : secondWord.toCharArray()) {
            secondChars.add(secondChar);
        }

        if (firstChars.size() != secondChars.size()) {
            System.out.println("false");
            return;
        }


        Map<Character, Character> mapping = new HashMap<>();

        for (int i = 0; i < firstWord.length(); i++) {
            try {
                if (mapping.containsKey(firstWord.charAt(i))) {
                    if (mapping.get(firstWord.charAt(i))
                            != secondWord.charAt(i)) {
                        System.out.println("false");
                        return;
                    }
                } else {
                    mapping.put(firstWord.charAt(i), secondWord.charAt(i));
                }
            } catch (Exception e) {
                if (mapping.containsKey(firstWord.charAt(i))) {
                    continue;
                }
                System.out.println("false");
            }
        }

        System.out.println("true");
    }
}