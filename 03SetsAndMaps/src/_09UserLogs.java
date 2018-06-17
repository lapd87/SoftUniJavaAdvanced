import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:47 ч.
 */
public class _09UserLogs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Map<String, Map<String, Integer>> userLogs = new TreeMap<>();

        String input;
        while (!"end".equals(input = console.nextLine())) {

            String[] ipMsgUser = input.split("[=| ]");

            String ip = ipMsgUser[1];
            String user = ipMsgUser[5];

            userLogs.putIfAbsent(user, new LinkedHashMap<>());

            Map<String, Integer> currentIPs = userLogs.get(user);
            currentIPs.putIfAbsent(ip, 0);
            currentIPs.put(ip, currentIPs.get(ip) + 1);

            userLogs.put(user, currentIPs);
        }

        for (Map.Entry<String, Map<String, Integer>> entry : userLogs.entrySet()) {

            System.out.println(entry.getKey() + ": ");

            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<String, Integer> ipEntries : entry.getValue().entrySet()) {
                stringBuilder.append(ipEntries.getKey())
                        .append(" => ")
                        .append(ipEntries.getValue())
                        .append(", ");
            }

            stringBuilder
                    .replace(stringBuilder.length() - 2,
                            stringBuilder.length(), ".");

            System.out.println(stringBuilder);
        }
    }
}