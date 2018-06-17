import java.io.File;
import java.util.ArrayDeque;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:24 ч.
 */
public class _008NestedFolders {
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

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.add(rootDir);

        System.out.println(rootDir.getName());

        int counter = 1;

        while (!queue.isEmpty()) {
            File currentDir = queue.remove();

            File[] currentFiles = currentDir.listFiles();

            if (currentFiles == null) {
                continue;
            }

            for (File file : currentFiles) {
                if (file.isDirectory()) {
                    counter++;
                    System.out.println(file.getName());
                    queue.add(file);
                }
            }
        }
        System.out.printf("%d folders", counter);
    }
}
