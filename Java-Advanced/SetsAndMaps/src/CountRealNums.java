import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Map<Double, Integer> result = new LinkedHashMap<>();

        for (String inputElement : input) {
            Double key = Double.parseDouble(inputElement);

            result.putIfAbsent(key, 0);
            result.put(key, result.get(key) + 1);

        }


        for (Map.Entry<Double, Integer> kvp : result.entrySet()) {
            System.out.println(String.format("%.1f -> %s", kvp.getKey(), kvp.getValue()));
        }
    }
}
