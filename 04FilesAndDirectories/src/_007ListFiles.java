import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:24 ч.
 */
public class _007ListFiles {
    public static void main(String[] args) {

        String path = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String rootDirectoryPath = path + "Files-and-Streams";

        File rootDir = new File(rootDirectoryPath);

        if (!rootDir.exists()) {
            return;
        }

        File[] files = rootDir.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (!file.isDirectory()) {
                System.out.printf("%s: %s%n",
                        file.getName(), file.length());
            }
        }
    }
}