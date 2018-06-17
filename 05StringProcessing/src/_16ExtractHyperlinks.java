import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:37 ч.
 */
public class _16ExtractHyperlinks {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        StringBuilder stringBuilder = new StringBuilder();

        String input;
        while (!"END".equals(input = console.nextLine())) {
            stringBuilder.append(input);
        }

        String regex = "<a[^<>]+?href\\s*=\\s*(\".*?\"|'.*?'|(.*?))[\\s>]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringBuilder);

        while (matcher.find()) {
            String url = matcher.group(1);

            if (url.startsWith("'")||url.startsWith("\"")){
                url=url.substring(1,url.length()-1);
            }
            System.out.println(url);
        }
    }
}