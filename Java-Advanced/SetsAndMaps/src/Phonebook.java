import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String find = "";

        HashMap<String, String> phonebook = new HashMap<>();

        while (!"search".equals(find = scanner.nextLine())) {

            String[] input = find.split("-");

            String name = input[0];
            String number = input[1];

            phonebook.put(name, number);

        }

        String input = "";

        while (!"stop".equals(input = scanner.nextLine())){
            if (phonebook.containsKey(input)){
                System.out.println(String.format("%s -> %s", input, phonebook.get(input)));
            } else {
                System.out.println(String.format("Contact %s does not exist.", input));
            }
        }
    }
}
