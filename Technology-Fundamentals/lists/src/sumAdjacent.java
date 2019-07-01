import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sumAdjacent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] numbers = input.split("\\s+");

        List<Double> doubleList = new ArrayList<>();

        for (String number : numbers) {
            doubleList.add(Double.parseDouble(number));
        }

        for (int i = 0; i < doubleList.size() - 1; i++) {

            double firstNumber = doubleList.get(i);
            double secondNumber = doubleList.get(i + 1);

            if (firstNumber == secondNumber) {
                double sum = firstNumber + secondNumber;

                doubleList.set(i, sum);
                doubleList.remove(i + 1);

                i = -1;
            }
        }

        System.out.println(concatListElements(doubleList));

    }

    static String concatListElements(List<Double> list) {
        String someString = "";

        DecimalFormat format = new DecimalFormat("#.###");

        for (Double num : list) {
            someString += format.format(num) + " ";

        }

        return someString.trim();
    }
}
