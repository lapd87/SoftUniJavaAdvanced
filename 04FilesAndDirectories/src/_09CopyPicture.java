import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:26 ч.
 */
public class _09CopyPicture {
    public static void main(String[] args) {

        String resourcePath = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String inputPath = resourcePath + "\\Deso-softuni.jpg";
        String outputPath = resourcePath + "\\Deso-softuni-copy.jpg";


        try (InputStream inputStream = new FileInputStream(inputPath);
             OutputStream outputStream = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[1024];

            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}