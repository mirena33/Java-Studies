import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class santasList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> kidsList = Arrays.stream(scanner.nextLine().split("&"))
                .collect(Collectors.toList());

        String input = "";

        while (!"Finished!".equals(input = scanner.nextLine())) {
            String[] commands = input.split("\\s+");

            switch (commands[0]) {
                case "Bad":
                    if (!kidsList.contains(commands[1])) {
                        kidsList.add(0, commands[1]);
                    }
                    break;

                case "Good":
                    if (kidsList.contains(commands[1])) {
                        kidsList.remove(commands[1]);
                    }
                    break;

                case "Rename":
                    if (kidsList.contains(commands[1])) {
                        int index = kidsList.indexOf(commands[1]);
                        kidsList.set(index, commands[2]);
                    }
                    break;

                case "Rearrange":
                    if (kidsList.contains(commands[1])) {
                        kidsList.remove(commands[1]);
                        kidsList.add(commands[1]);
                    }

                    break;

            }


        }

        System.out.println(String.join(", ", kidsList));
    }
}
