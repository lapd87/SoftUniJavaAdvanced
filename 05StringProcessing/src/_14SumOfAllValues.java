import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.5.2018 г.
 * Time: 10:37 ч.
 */
public class _14SumOfAllValues {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String keys = console.nextLine();
        String text = console.nextLine();

        Pattern startKeyPattern = Pattern
                .compile("^([A-Za-z_]+)\\d");
        Matcher startKeyMatcher = startKeyPattern
                .matcher(keys);
        Pattern endKeyPattern = Pattern
                .compile("\\d([A-Za-z_]+)$");
        Matcher endKeyMatcher = endKeyPattern
                .matcher(keys);

        if (!startKeyMatcher.find() || !endKeyMatcher.find()) {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        String startKey = startKeyMatcher.group(1);
        String endKey = endKeyMatcher.group(1);

        Pattern pattern = Pattern
                .compile(Pattern.quote(startKey)
                        + "(\\d*[\\.]{0,1}\\d*?)"
                        + Pattern.quote(endKey));
        Matcher matcher = pattern
                .matcher(text);

        List<Double> nums = new ArrayList<>();
        int i = matcher.groupCount();
        while (matcher.find()) {
            nums.add(Double.parseDouble(matcher.group(1)));
        }

        if (nums.isEmpty()) {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        } else {
            double sum = nums.stream()
                    .reduce((a, b) -> a + b)
                    .get();

            if (sum == (int) sum) {
                System.out.printf("<p>The total value is: <em>" +
                        "%d</em></p>%n", (int) sum);
            } else {
                System.out.printf("<p>The total value is: <em>" +
                        "%.2f</em></p>%n", sum);
            }
        }
    }
}