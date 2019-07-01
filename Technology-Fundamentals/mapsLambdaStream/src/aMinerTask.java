import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class aMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader
                (new InputStreamReader(System.in));

        String input = "";

        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!"stop".equals(input = reader.readLine())) {
            String resource = input;
            int quantity = Integer.parseInt(reader.readLine());

            if (!resources.containsKey(resource)) {
                resources.put(resource, quantity);
            } else {
                resources.put(resource, resources.get(resource) + quantity);
            }

        }

        resources.entrySet().forEach(e -> {
            System.out.println(String.format("%s -> %d", e.getKey(), e.getValue()));
        });
    }
}
