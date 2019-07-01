import java.util.*;

public class studentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentInformation = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            studentInformation.putIfAbsent(name, new ArrayList<>());
            studentInformation.get(name).add(grade);
        }


        studentInformation
                .entrySet()
                .stream()
                .filter(g -> g.getValue().stream().mapToDouble(x -> x).average().getAsDouble() >= 4.50)
                .sorted((e1, e2) -> {

                    double average1 = e1.getValue().stream().mapToDouble(x -> x).average().getAsDouble();
                    double average2 = e2.getValue().stream().mapToDouble(x -> x).average().getAsDouble();

                    int sort = Double.compare(average2, average1);
                    return sort;


                })
                .forEach(e -> {
                    System.out.println(String.format("%s -> %.2f",
                            e.getKey(), e.getValue().stream().mapToDouble(x -> x).average().getAsDouble()));
                });

    }
}
