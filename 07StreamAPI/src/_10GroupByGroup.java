import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:31 ч.
 */
public class _10GroupByGroup {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Person> students = new ArrayList<>();

        while (true) {
            String[] input = console.nextLine()
                    .split("\\s+");

            if ("END".equals(input[0])) {
                break;
            }

            String name = input[0] + " " + input[1];
            Integer group = Integer.parseInt(input[2]);

            Person student = new Person(name, group);
            students.add(student);
        }

        Map<Integer, List<Person>> groupedStudents = students.stream()
                .collect(Collectors.groupingBy(Person::getGroup));

        groupedStudents.entrySet()
                .forEach(g -> {
                    System.out.print(g.getKey() + " - ");

                    StringBuilder stringBuilder = new StringBuilder();
                    g.getValue()
                            .stream()
                            .forEach(s -> stringBuilder.append(s.getName())
                                    .append(", "));

                    System.out.println(stringBuilder.toString()
                            .substring(0, stringBuilder.length() - 2));
                });
    }


}

class Person {
    private String name;
    private Integer group;

    public Person() {
    }

    public Person(String name, Integer group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }
}

