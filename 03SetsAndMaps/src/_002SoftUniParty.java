import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:44 ч.
 */
public class _002SoftUniParty {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();

        String input;
        while (!"PARTY".equals(input = console.nextLine())) {
            guests.add(input);
        }

        while (!"END".equals(input = console.nextLine())) {
            guests.remove(input);
        }

        System.out.println(guests.size());

        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}