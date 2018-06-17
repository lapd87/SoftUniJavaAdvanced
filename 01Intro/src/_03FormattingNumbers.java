import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.5.2018 г.
 * Time: 14:23 ч.
 */
public class _03FormattingNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine()
                .split("\\s+", -1);

        int a = Integer.parseInt(input[0]);
        double b = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);

        String aHEX = Integer.toHexString(a).toUpperCase();
        String aHexSpaces = String.join("",
                Collections.nCopies(10 - aHEX.length(), " "));

        String aBinary = Integer.toBinaryString(a);
        String aBinaryZeros = String.join("",
                Collections.nCopies(10 - aBinary.length(), "0"));

        DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
        DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
        char separator = symbols.getDecimalSeparator();

        int bIntegerPlaces = String.valueOf(b).indexOf(separator);
        String bFloatSpaces = String.join("",
                Collections.nCopies(10 - bIntegerPlaces - 3, " "));

        int cIntegerPlaces = String.valueOf(c).indexOf(separator);
        String cFloatSpaces = String.join("",
                Collections.nCopies(10 - cIntegerPlaces - 4, " "));

        String result = String.format("|%s%s|%s%s|%s%.2f|%.3f%s|",
                aHEX, aHexSpaces,
                aBinaryZeros, aBinary,
                bFloatSpaces, b,
                c, cFloatSpaces);

        System.out.println(result);
    }

}