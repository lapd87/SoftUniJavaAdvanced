import java.io.File;
import java.util.ArrayDeque;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:26 ч.
 */
public class _08GetFolderSize {
    public static void main(String[] args) {

        String resourcePath = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String rootDirectoryPath = resourcePath + "ExercisesResources";

        File rootDir = new File(rootDirectoryPath);

        if (!rootDir.exists()) {
            return;
        }


        System.out.println("Folder size: " + getFolderSize(rootDir));
    }


    private static long getFolderSize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();

        int count = files.length;

        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            } else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }
}