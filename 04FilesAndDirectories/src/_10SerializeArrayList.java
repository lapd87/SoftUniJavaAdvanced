import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:26 ч.
 */
public class _10SerializeArrayList {
    public static void main(String[] args) {

        String resourcePath = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String outputPath = resourcePath + "\\list.ser";

        List<Double> doubles = new ArrayList<>();

        for (int i = 0; i < 100; i += 3) {
            Random random = new Random();
            doubles.add(random.nextDouble() * i);
        }

        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream((new FileOutputStream(outputPath)))) {

            objectOutputStream.writeObject(doubles);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream =
                     new ObjectInputStream((new FileInputStream(outputPath)))) {

            @SuppressWarnings("unchecked")
            List<Double> result = (List<Double>) objectInputStream.readObject();

            for (Double aDouble : result) {
                System.out.println(aDouble);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}