import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, Set<String>> bandGroups = new LinkedHashMap<>();
        Map<String, List<Integer>> bandTime = new LinkedHashMap<>();

        while (!"start of concert".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\;");

            String command = data[0];
            String bandName = data[1];

            switch (command) {
                case "Add":
                    String[] bandMembers = data[2].split("\\,");

                    if (!bandGroups.containsKey(bandName)) {
                        bandGroups.put(bandName, new LinkedHashSet<>());
                        bandTime.put(bandName, new ArrayList<>());
                    }

                    for (int i = 0; i < bandMembers.length; i++) {
                        bandGroups.get(bandName).add(bandMembers[i]);
                    }

                    break;

                case "Play":
                    int time = Integer.parseInt(data[2].trim());

                    if (!bandTime.containsKey(bandName)) {
                        bandTime.put(bandName, new ArrayList<>());
                        bandGroups.put(bandName, new LinkedHashSet<>());

                    }

                    bandTime.get(bandName).add(time);

                    break;
            }

        }

        String bandNameInput = scanner.nextLine();

        System.out.println("Total time: ");



        bandGroups
                .entrySet()
                .stream()
                .filter(e -> e.getKey().equals(bandNameInput))
                .forEach(e-> {
                    System.out.println(e.getKey());

                    e.getValue().forEach(member -> System.out.println(String.format("=> %s", member)));
                });

    }
}
