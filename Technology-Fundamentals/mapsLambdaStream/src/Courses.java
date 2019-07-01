import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        Map<String, TreeSet<String>> courses = new LinkedHashMap<>();

        while (!"end".equals(input = scanner.nextLine())) {
            String[] data = input.split(" : ");

            String singleCourse = data[0];
            String name = data[1];

            courses.putIfAbsent(singleCourse, new TreeSet<>());
            courses.get(singleCourse).add(name);

        }

courses
        .entrySet()
        .stream()
        .sorted((e1,e2) ->Integer.compare(e2.getValue().size(), e1.getValue().size()))
        .forEach(e -> {
            System.out.printf("%s: %d\n", e.getKey(),e.getValue().size());

            e.getValue()
                    .forEach(studentName -> {
                        System.out.printf("-- %s\n", studentName);
                    });

        });
    }
}
