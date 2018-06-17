import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:48 ч.
 */
public class _11LogsAggregator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        Map<String, Map<String, Integer>> logs = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String[] inputArgs = console.nextLine()
                    .split("\\s+");

            String ip = inputArgs[0];
            String user = inputArgs[1];
            Integer duration = Integer.parseInt(inputArgs[2]);

            logs.putIfAbsent(user, new TreeMap<>());

            Map<String, Integer> ipDuration = logs.get(user);
            ipDuration.putIfAbsent(ip, 0);
            ipDuration.put(ip, ipDuration.get(ip) + duration);

            logs.put(user, ipDuration);
        }

        for (Map.Entry<String, Map<String, Integer>> user : logs.entrySet()) {

            int totalDuration = 0;
            List<String> ipList = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : user.getValue().entrySet()) {
                ipList.add(entry.getKey());
                totalDuration += entry.getValue();
            }

            System.out.println(user.getKey() + ": "
                    + totalDuration + " ["
                    + String.join(", ", ipList) + "]");
        }
    }
}