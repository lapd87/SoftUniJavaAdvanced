import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 9.6.2018 г.
 * Time: 19:07 ч.
 */
public class _03 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^([a-z\\!\\@\\#\\$\\?]+)=(\\d+)--(\\d+)<<([a-z]+)$");
        String[] nameCharsRemove = new String[]{"!", "@", "#", "$", "?"};

        Map<String, Integer> organismGenesCount = new LinkedHashMap<>();

        String input;
        while (!"Stop!".equals(input = bufferedReader.readLine())) {

            Matcher matcher = pattern.matcher(input);

            if (!matcher.find()) {
                continue;
            }

            String geneName = matcher.group(1);

            for (String c : nameCharsRemove) {
                if (geneName.contains(c)) {
                    geneName = geneName.replaceAll(Pattern.quote(c), "");
                }
            }

            int geneNameLength = Integer.parseInt(matcher.group(2));

            if (geneName.length() != geneNameLength) {
                continue;
            }

            int genesCount = Integer.parseInt(matcher.group(3));
            String organismName = matcher.group(4);

            organismGenesCount.putIfAbsent(organismName, 0);
            organismGenesCount.put(organismName,
                    organismGenesCount.get(organismName) + genesCount);
        }

        organismGenesCount.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .forEach(o -> System.out.printf("%s has genome size of %d%n",
                        o.getKey(), o.getValue()));
    }
}