import java.io.*;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:24 ч.
 */
public class _009SerializeCustomObject {
    public static void main(String[] args) {

        String path = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String outputPath = path + "outputSerialize.txt";

        Cube cube = new Cube("green", 15.3,
                12.4, 3.0);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream((new FileOutputStream(outputPath)))) {

            objectOutputStream.writeObject(cube);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Cube implements Serializable {
    private String color;
    private Double width;
    private Double height;
    private Double depth;

    public Cube() {
    }

    public Cube(String color, Double width,
                Double height, Double depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }
}