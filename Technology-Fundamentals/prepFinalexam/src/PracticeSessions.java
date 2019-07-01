import java.util.*;

public class PracticeSessions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, List<String>> sessions = new LinkedHashMap<>();

        while (!"END".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s*->\\s*");

            String command = data[0];
            String road = data[1];

            switch (command) {
                case "Add":
                    if (!sessions.containsKey(road)) {
                        sessions.put(road, new ArrayList<>());
                    }

                    sessions.get(road).add(data[2]);
                    break;


                case "Move":
                    if (sessions.get(road).contains(data[2])) {
                        sessions.get(road).remove(data[2]);
                        sessions.get(data[3]).add(data[2]);
                    }

                    break;


                case "Close":
                    if (sessions.containsKey(road)) {
                        sessions.remove(road);
                    }
                    break;

            }

        }

        System.out.println("Practice sessions:");

        sessions
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int firstEl = e1.getValue().size();
                    int secondEl = e2.getValue().size();

                    int sort = Integer.compare(secondEl, firstEl);

                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }

                    return sort;
                })
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().forEach(r -> System.out.println(String.format("++%s", r)));
                        }

                );

    }
}
