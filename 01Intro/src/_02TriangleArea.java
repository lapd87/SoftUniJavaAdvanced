import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:23 ч.
 */
public class _02TriangleArea {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int x1 = console.nextInt();
        int y1 = console.nextInt();
        console.nextLine();

        int x2 = console.nextInt();
        int y2 = console.nextInt();
        console.nextLine();

        int x3 = console.nextInt();
        int y3 = console.nextInt();
        console.nextLine();

        double area = (x1 * (y2 - y3)
                + x2 * (y3 - y1)
                + x3 * (y1 - y2)) / 2;

        if (area < 0) {
            area *= -1;
        }

        System.out.printf("%.0f%n", area);
    }
}