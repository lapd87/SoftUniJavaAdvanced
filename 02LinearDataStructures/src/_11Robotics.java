import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 22.5.2018 г.
 * Time: 08:57 ч.
 */
public class _11Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] robotsData = bufferedReader.readLine()
                .split(";");

        int robotsCount = robotsData.length;

        String[] robotsName = new String[robotsCount];
        int[] robotsDefaultProcessTime = new int[robotsCount];
        int[] robotsCurrentProgress = new int[robotsCount];

        String[] robotData;
        for (int i = 0; i < robotsCount; i++) {
            robotData = robotsData[i]
                    .split("-");

            robotsName[i] = robotData[0];
            robotsDefaultProcessTime[i] = Integer
                    .parseInt(robotData[1]);
            robotsCurrentProgress[i] = Integer
                    .parseInt(robotData[1]);
        }

        String[] timeData = bufferedReader.readLine()
                .split("(:0)+|:+");

        int hours = Integer.parseInt(timeData[0]);
        int mins = Integer.parseInt(timeData[1]);
        int secs = Integer.parseInt(timeData[2]);

        ArrayDeque<String> productsQueue = new ArrayDeque<>();

        String productName;
        while (!"End".equals(productName = bufferedReader.readLine())) {
            productsQueue.add(productName);
        }

        StringBuilder result = new StringBuilder();

        boolean hasFreeRobot;
        int freeRobotIndex;

        while (productsQueue.size() > 0) {
            secs++;

            hasFreeRobot = false;
            freeRobotIndex = -1;

            for (int i = 0; i < robotsCount; i++) {
                robotsCurrentProgress[i]++;

                if (!hasFreeRobot
                        && robotsCurrentProgress[i] >= robotsDefaultProcessTime[i]) {
                    hasFreeRobot = true;
                    freeRobotIndex = i;
                }
            }

            if (hasFreeRobot) {
                robotsCurrentProgress[freeRobotIndex] = 0;

                while (secs >= 60) {
                    mins++;
                    secs -= 60;
                }

                while (mins >= 60) {
                    hours++;
                    mins -= 60;
                }

                while(hours>=24){
                    hours-=24;
                }

                result.append(robotsName[freeRobotIndex])
                        .append(" - ")
                        .append(productsQueue.remove())
                        .append(" [")
                        .append(String.format("%02d", hours))
                        .append(":")
                        .append(String.format("%02d", mins))
                        .append(":")
                        .append(String.format("%02d", secs))
                        .append("]")
                        .append(System.lineSeparator());

            } else {
                productsQueue.add(productsQueue.remove());
            }
        }

        System.out.println(result);
    }
}