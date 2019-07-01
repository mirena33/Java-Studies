import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> stringList = Arrays.stream(input.split(" "))
                .collect(Collectors.toList());

        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < stringList.size(); i++) {
            int currentNumber = Integer.parseInt(stringList.get(i));

            numberList.add(currentNumber);
        }
        System.out.println(numberList);

//         List<Integer> listOfNumbers = Arrays.stream(scanner.nextLine.split(" "))
//                 .map(Integer::parseInt)
//                 .collect(Collectors.toList());
    }
}
