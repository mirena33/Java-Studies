import java.util.*;
import java.util.stream.Collectors;

public class AverageGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsAndGrades = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String line = scanner.nextLine();
            String[] tokens = line.split("\\s+");

            studentsAndGrades.putIfAbsent(tokens[0], new ArrayList<>());
            studentsAndGrades.get(tokens[0]).add(Double.parseDouble(tokens[1]));


        }


        studentsAndGrades.forEach((name, grade) -> {

            String allGrades = grade.stream()
                    .map(g -> String.format("%.2f", g))
                    .collect(Collectors.joining(" "));

            double avg = grade.stream().mapToDouble(e -> e).average().getAsDouble();

            System.out.println(String.format("%s -> %s (avg: %.2f)", name, allGrades, avg));
        });
    }
}
