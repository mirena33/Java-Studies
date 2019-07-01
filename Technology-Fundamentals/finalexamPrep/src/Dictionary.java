import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] descriptions = scanner.nextLine().split("\\s*\\|\\s*");
        String[] words = scanner.nextLine().split("\\s*\\|\\s*");
        String command = scanner.nextLine();

        Map<String, List<String>> dictionaryWords = new LinkedHashMap<>();

        for (int i = 0; i < descriptions.length; i++) {
            String[] data = descriptions[i].split("\\s*:\\s*");

            dictionaryWords.putIfAbsent(data[0], new ArrayList<>());
            dictionaryWords.get(data[0]).add(data[1]);


        }

        if (command.equals("List")) {
            dictionaryWords
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparing(Map.Entry::getKey))
                    .forEach((kvp) -> System.out.print(String.format("%s ", kvp.getKey())));
        } else {

            dictionaryWords
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingInt(e -> dictionaryWords.get(e.getKey()).size()))
                    .forEach((kvp) ->
                        System.out.println(kvp.getKey() + "\n -" + String.join("\n -", new ArrayList<>(kvp.getValue())))
                    );


        }
    }
}
