import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:27 ч.
 */
public class _003FirstName {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split("\\s+");

        List<Character> filter = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .map(s -> s.toLowerCase().charAt(0))
                .distinct()
                .collect(Collectors.toList());

        String mathces = Arrays.stream(input)
                .filter(x -> filter.contains(x.toLowerCase().charAt(0)))
                .sorted()
                .limit(1)
                .collect(Collectors.joining());

        if (mathces.isEmpty()) {
            System.out.println("No match");
        } else {
            System.out.println(mathces);
        }
    }
}