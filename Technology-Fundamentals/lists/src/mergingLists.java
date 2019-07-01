import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class mergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int minLength = Math.min(firstNumbers.size(), secondNumbers.size());

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < minLength; i++) {

            resultList.add(firstNumbers.get(i));
            resultList.add(secondNumbers.get(i));
        }

        if (firstNumbers.size() > secondNumbers.size()) {

            resultList.addAll(firstNumbers
                    .subList(minLength, firstNumbers.size()));
        } else {
            resultList.addAll(secondNumbers.subList(minLength,secondNumbers.size()));
        }
        System.out.println(resultList
                .toString().replaceAll("[\\[,\\]]", ""));
    }
}
