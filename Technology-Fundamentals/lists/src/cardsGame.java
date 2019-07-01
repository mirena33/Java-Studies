import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class cardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstHand = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondHand = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        while (!(firstHand.isEmpty() || secondHand.isEmpty())) {
            if (firstHand.get(0).equals(secondHand.get(0))) {
                firstHand.remove(0);
                secondHand.remove(0);

            } else if (firstHand.get(0) > secondHand.get(0)) {

                firstHand.add(firstHand.get(0));
                firstHand.add(secondHand.get(0));

                firstHand.remove(0);
                secondHand.remove(0);

            } else if (secondHand.get(0) > firstHand.get(0)) {

                secondHand.add(secondHand.get(0));
                secondHand.add(firstHand.get(0));

                secondHand.remove(0);
                firstHand.remove(0);
            }
        }

        if (firstHand.isEmpty()) {
            for (int i = 0; i < secondHand.size(); i++) {

                sum += secondHand.get(i);
            }
            System.out.println("Second player wins! Sum: " + sum);

        } else {
            for (int i = 0; i < firstHand.size(); i++) {

                sum += firstHand.get(i);
            }
            System.out.println("First player wins! Sum: " + sum);
        }
    }
}
