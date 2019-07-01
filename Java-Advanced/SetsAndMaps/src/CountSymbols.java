import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        TreeMap<Character, Integer> symbolsCount = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (!symbolsCount.containsKey(symbol)){
                symbolsCount.put(symbol, 1);

            } else {
                symbolsCount.put(symbol, symbolsCount.get(symbol) + 1);
            }

        }

        for (Map.Entry<Character, Integer> kvp : symbolsCount.entrySet()) {
            System.out.printf("%c: %d time/s\n", kvp.getKey(), kvp.getValue());
        }
    }
}
