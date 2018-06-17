import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:24 ч.
 */
public class _09ByteParty {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(console.nextLine());
            numbers[i] = num;
        }

        String command;
        while (true) {
            if ("party over".equals(command = console.nextLine())) {
                for (Integer number : numbers) {
                    System.out.println(number);
                }
                break;
            }

            String action = command.split("\\s+")[0];
            int position = Integer.parseInt(command
                    .split("\\s+")[1]);

            switch (action) {
                case "-1":
                    for (int i = 0; i < n; i++) {
                        numbers[i] ^= (1 << position); //switch 0 and 1
                    }
                    break;
                case "0":
                    for (int i = 0; i < n; i++) {
                        numbers[i] &= (~(1 << position)); //switch to 0
                    }
                    break;
                case "1":
                    for (int i = 0; i < n; i++) {
                        numbers[i] |= (1 << position); // switch to 1
                    }
                    break;
            }
        }
    }
}