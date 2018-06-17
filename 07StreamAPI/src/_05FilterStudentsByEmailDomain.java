import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:30 ч.
 */
public class _05FilterStudentsByEmailDomain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<String> studentMails = new ArrayList<>();

        String input;
        while (!"END".equals(input = console.nextLine())) {
            studentMails.add(input);
        }

        studentMails.stream()
                .filter(s -> s.split("@")[1]
                        .equals("gmail.com"))
                .forEach(s -> System.out.println(s.substring(0,
                        s.lastIndexOf(" "))));
    }
}