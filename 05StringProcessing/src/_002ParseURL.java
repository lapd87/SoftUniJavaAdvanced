import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:32 ч.
 */
public class _002ParseURL {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        try {
            String[] input = console.nextLine()
                    .split("://");

            if (input.length!=2){
                throw new IllegalArgumentException();
            }

            String protocol = input[0];

            String[] serverResource = input[1].split("/", 2);

            String server = serverResource[0];
            String resource = serverResource[1];

            System.out.println("Protocol = " + protocol);
            System.out.println("Server = " + server);
            System.out.println("Resources = " + resource);
        } catch (Exception e) {
            System.out.println("Invalid URL");
        }
    }
}