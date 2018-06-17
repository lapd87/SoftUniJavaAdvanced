import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:26 ч.
 */
public class _12CreateZipArchive {
    public static void main(String[] args) {

        String resourcePath = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String input1Path = resourcePath + "_this.txt";
        String input2Path = resourcePath + "_is.txt";
        String input3Path = resourcePath + "_zip.txt";
        String outputPath = resourcePath + "_thisIsZip.zip";

        try (PrintWriter writer1 = new PrintWriter(input1Path);
             PrintWriter writer2 = new PrintWriter(input2Path);
             PrintWriter writer3 = new PrintWriter(input3Path)) {

            writer1.write("this");
            writer2.write("is");
            writer3.write("zip");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputStream outputStream = new FileOutputStream(outputPath);
             ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream)) {

            zipFiles(input1Path, zipOutputStream);
            zipFiles(input2Path, zipOutputStream);
            zipFiles(input3Path, zipOutputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void zipFiles(String inputPath, ZipOutputStream zipOutputStream) {

        byte[] buffer = new byte[4096];

        try (FileInputStream inputStream = new FileInputStream(inputPath)) {
            zipOutputStream.putNextEntry(new ZipEntry(inputPath
                    .substring(inputPath.lastIndexOf('\\') + 1)));

            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}