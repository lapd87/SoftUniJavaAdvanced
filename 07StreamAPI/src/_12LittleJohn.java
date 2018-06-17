import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:31 ч.
 */
public class _12LittleJohn {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String smallArrow = ">----->";
        String mediumArrow = ">>----->";
        String largeArrow = ">>>----->>";

        int[] arrowTypeCount = new int[3];

        for (int i = 0; i < 4; i++) {
            String input = console.nextLine();

            int smallCount = 0;
            int mediumCount = 0;
            int largeCount = 0;

            while (input.contains(largeArrow)) {
                largeCount++;
                input = input.replaceFirst(largeArrow, " ");
            }

            while (input.contains(mediumArrow)) {
                mediumCount++;
                input = input.replaceFirst(mediumArrow, " ");
            }

            while (input.contains(smallArrow)) {
                smallCount++;
                input = input.replaceFirst(smallArrow, " ");
            }

            arrowTypeCount[0] += smallCount;
            arrowTypeCount[1] += mediumCount;
            arrowTypeCount[2] += largeCount;
        }

        String totalCount = "" + arrowTypeCount[0]
                + arrowTypeCount[1]
                + arrowTypeCount[2];

        String totalCountBinary = Integer
                .toBinaryString(Integer
                        .parseInt(totalCount));

        StringBuilder binaryEncoded = new StringBuilder(totalCountBinary);
        binaryEncoded.append(new StringBuilder(totalCountBinary).reverse());

        int result = Integer.parseInt(binaryEncoded.toString(), 2);

        System.out.println(result);
    }
}