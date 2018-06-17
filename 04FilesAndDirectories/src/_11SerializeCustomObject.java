import java.io.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 25.5.2018 г.
 * Time: 18:26 ч.
 */
public class _11SerializeCustomObject {
    public static void main(String[] args) {

        String path = "C:\\VBprojects\\JavaAdvanced05.2018\\" +
                "04FilesAndDirectories\\recources\\";

        String outputPath = path + "course.ser";

        Course saveCourse = new Course("Pesho", 134);
        Course loadCourse = new Course();

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream((new FileOutputStream(outputPath)))) {

            objectOutputStream.writeObject(saveCourse);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream =
                     new ObjectInputStream((new FileInputStream(outputPath)))) {

            loadCourse = (Course) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(loadCourse.toString()
                .equals(saveCourse.toString()));
    }
}

class Course implements Serializable {
    private String name;
    private int studentCount;

    Course() {
    }

    Course(String name, int studentCount) {
        this.name = name;
        this.studentCount = studentCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", studentCount=" + studentCount +
                '}';
    }
}