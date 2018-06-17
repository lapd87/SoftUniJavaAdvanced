import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:35 ч.
 */
public class _05Palindromes {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split("[ ,.?!]", -1);

        Set<String> palindromes = new TreeSet<>();

        for (String s : input) {
            if (s.isEmpty()){
                continue;
            }

            StringBuilder stringBuilder = new StringBuilder(s);

            if (s.contentEquals(stringBuilder.reverse())) {
                palindromes.add(s);
            }
        }

        System.out.println(palindromes);
    }
}