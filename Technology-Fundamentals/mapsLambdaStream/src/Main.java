import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> someMap = new TreeMap<>();

        for (double  num: nums) {
            if (!someMap.containsKey(num)){

                someMap.put(num, 0);
            }

            int oldValue = someMap.get(num);

            someMap.put(num, oldValue + 1);
        }

        String pattern = "%.0f -> %d";

        for (Map.Entry<Double, Integer> kvp: someMap.entrySet()) {

            System.out.println(String.format(pattern, kvp.getKey(), kvp.getValue()));

        }
    }
}
