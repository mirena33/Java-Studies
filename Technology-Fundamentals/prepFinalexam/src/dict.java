import java.util.*;

public class dict {
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
                    .forEach((kvp) -> System.out.print(String.format("%s ", kvp.getKey().trim())));
        } else {

            dictionaryWords
                    .entrySet()
                    .stream()
                    .filter(w -> {
                        boolean check = false;
                        for (String word : words) {
                            if (w.getKey().equals(word)) {
                                check = true;
                            }
                        }
                        return check;
                    })
                    .sorted((e1, e2) -> {
                        int firstEl = e1.getValue().stream().toString().length();
                        int secondEl = e2.getValue().stream().toString().length();

                        return Integer.compare(firstEl, secondEl);
                    })
                    .forEach((kvp) ->
                            System.out.println(kvp.getKey() + "\n -" + String.join("\n -", new ArrayList<>(kvp.getValue())))
                    );


        }
    }
}
