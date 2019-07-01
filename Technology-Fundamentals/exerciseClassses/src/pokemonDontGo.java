import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class pokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        while (elements.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            int element = 0;

            if (index < 0) {

                element = elements.get(0);
                elements.set(0, elements.get(elements.size() - 1));

            } else if (index >= elements.size()) {

                element = elements.get(elements.size() - 1);
                elements.set(elements.size() - 1, elements.get(0));

            } else {

                element = elements.get(index);
                elements.remove(index);
            }

            sum += element;
            increaseOrDecreaseElement(elements, element);
        }

        System.out.println(sum);

    }

    private static void increaseOrDecreaseElement(List<Integer> elements, int element) {

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) <= element) {
                elements.set(i, elements.get(i) + element);
            } else {
                elements.set(i, elements.get(i) - element);
            }
        }
    }
}
