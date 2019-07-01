import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheFinalQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = "";

        while (!"Stop".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");

            switch (data[0]) {
                case "Delete":
                    int index = Integer.parseInt(data[1]);
                    if (index + 1 >= 0 && index + 1 < words.size()) {
                        words.remove(index + 1);
                    }
                    break;

                case "Swap":
                    int firstIndex = words.indexOf(data[1]);
                    int secondIndex = words.indexOf(data[2]);

                    if (words.contains(data[1]) && words.contains(data[2])) {

                        words.set(firstIndex, data[2]);
                        words.set(secondIndex, data[1]);
                    }

                    break;

                case "Put":
                    int indexPut = Integer.parseInt(data[2]);
                    if (indexPut - 1 >= 0 && indexPut - 1 <= words.size()) {
                        words.add(indexPut - 1, data[1]);

                    }
                    break;

                case "Sort":
                    Collections.sort(words);
                    Collections.reverse(words);
                    break;

                case "Replace":
                    if (words.contains(data[2])) {
                        int indexWord = words.indexOf(data[2]);
                        words.set(indexWord, data[1]);
                    }

                    break;
            }


        }

        System.out.println(String.join(" ", words));
    }
}
