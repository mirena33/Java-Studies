import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());


        while (!words.isEmpty()) {

            Random random = new Random();

            int randomIndex = random.nextInt(words.size());

            String word = words.get(randomIndex);

            System.out.println(word);
            words.remove(randomIndex);
        }
    }
}
