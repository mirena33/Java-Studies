
import java.util.*;

public class oddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String word : words) {
            String lowerCase = word.toLowerCase();

            if (!counts.containsKey(lowerCase)) {
                counts.put(lowerCase, 1);
            } else {
                counts.put(lowerCase, counts.get(lowerCase) + 1);
            }
        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> kvp : counts.entrySet()) {
            if (kvp.getValue() % 2 == 1) {
                result.add(kvp.getKey());
            }
        }


        System.out.println(String.join(", ", result));
    }
}
