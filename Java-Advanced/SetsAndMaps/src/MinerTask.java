import java.util.LinkedHashMap;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        String input = "";

        while (!"stop".equals(input = scanner.nextLine())) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resources.containsKey(input)) {
                resources.put(input, quantity);
            } else {
                resources.put(input, resources.get(input) + quantity);
            }
        }

        resources.forEach((key, value) -> System.out.println(String.format("%s -> %s", key, value)));
    }
}
