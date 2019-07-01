import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class populationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> populationCounter = new LinkedHashMap<>();

        while (!"report".equals(input)) {

            String[] tokens = input.split("\\|");

            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);


            if (!populationCounter.containsKey(country)) {
                populationCounter.put(country, new LinkedHashMap<>() {{
                            put(city, population);
                        }}
                );
            } else {
                populationCounter.get(country).putIfAbsent(city, population);
            }

            input = scanner.nextLine();
        }

        populationCounter
                .entrySet()
                .stream()
                .sorted((f, s) -> {

                    long firstPopulation =
                            populationCounter
                                    .get(f.getKey())
                                    .entrySet()
                                    .stream()
                                    .mapToLong(Map.Entry::getValue)
                                    .sum();

                    long secondPopulation =
                            populationCounter
                                    .get(s.getKey())
                                    .entrySet()
                                    .stream()
                                    .mapToLong(Map.Entry::getValue)
                                    .sum();

                    return Long.compare(secondPopulation, firstPopulation);
                })
                .forEach(entry -> {

                    long totalPopulation = entry.getValue()
                            .values()
                            .stream()
                            .mapToLong(x -> x)
                            .sum();

                    System.out.println(String.format("%s (total population: %d)", entry.getKey(), totalPopulation
                    ));

                    entry
                            .getValue()
                            .entrySet()
                            .stream()
                            .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                            .forEach(e -> {
                                System.out.println(String.format("=>%s: %d", e.getKey(), e.getValue()));
                            });
                });
    }
}
