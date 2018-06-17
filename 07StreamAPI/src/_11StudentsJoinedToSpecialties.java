import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:31 ч.
 */
public class _11StudentsJoinedToSpecialties {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<StudentSpecialty> specialties = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        while (true) {

            String[] input = console.nextLine()
                    .split("\\s+");

            if ("Students:".equals(input[0])) {
                break;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < input.length - 1; i++) {
                stringBuilder.append(input[i])
                        .append(" ");
            }

            String specialtyName = stringBuilder.toString().trim();

            String facultyNumber = input[input.length - 1];

            StudentSpecialty studentSpecialty = new StudentSpecialty(specialtyName, facultyNumber);

            specialties.add(studentSpecialty);
        }

        while (true) {

            String[] input = console.nextLine()
                    .split("\\s+");

            if ("END".equals(input[0])) {
                break;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < input.length; i++) {
                stringBuilder.append(input[i])
                        .append(" ");
            }

            String studentName = stringBuilder.toString().trim();

            String facultyNumber = input[0];

            Student student = new Student(studentName, facultyNumber);

            students.add(student);
        }

        students.stream()
                .filter(s -> specialties.stream()
                        .anyMatch(sp -> sp.getFacultyNumber()
                                .equals(s.getFacultyNumber())))
                .sorted(Comparator.comparing(Student::getName))
                .forEach(s -> {
                    specialties.stream()
                            .filter(sp -> sp.getFacultyNumber()
                                    .equals(s.getFacultyNumber()))
                            .forEach(sp -> {
                                System.out.println(s.getName() + " "
                                        + s.getFacultyNumber() + " "
                                        + sp.getSpecialtyName());
                            });
                });
    }
}

class StudentSpecialty {
    private String specialtyName;
    private String facultyNumber;

    public StudentSpecialty() {
    }

    public StudentSpecialty(String specialtyName, String facultyNumber) {
        this.specialtyName = specialtyName;
        this.facultyNumber = facultyNumber;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}

class Student {
    private String name;
    private String facultyNumber;

    public Student() {
    }

    public Student(String name, String facultyNumber) {
        this.name = name;
        this.facultyNumber = facultyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}