import java.util.*;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:53 ч.
 */
public class _001EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int stringsCount = Integer.parseInt(console.nextLine());

        List<Character> vowels = Arrays.asList('a', 'o', 'e', 'i', 'u');

        List<Integer> encryptedResult = new ArrayList<>();

        for (int i = 0; i < stringsCount; i++) {

            String input = console.nextLine();

            int encrypted = 0;

            for (char letter : input.toCharArray()) {

                if (vowels.contains(Character.toLowerCase(letter))) {
                    encrypted += letter * input.length();
                } else {
                    encrypted += letter / input.length();
                }
            }

            encryptedResult.add(encrypted);
        }

        Collections.sort(encryptedResult);

        for (Integer encrypt : encryptedResult) {
            System.out.println(encrypt);
        }
    }
}