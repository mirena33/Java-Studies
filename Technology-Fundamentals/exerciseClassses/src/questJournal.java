import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class questJournal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> journal = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = "";

        while (!"Retire!".equals(input = scanner.nextLine())) {

            String[] tokens = input.split(" - ");
            String command = tokens[0];

            switch (command) {

                case "Start":
                    if (!journal.contains(tokens[1])) {
                        journal.add(tokens[1]);
                    }
                    break;

                case "Complete":
                    if (journal.contains(tokens[1])) {
                        journal.remove(tokens[1]);
                    }
                    break;

                case "Side Quest":
                    String[] questData = tokens[1].split(":");
                    String questName = questData[0];
                    String sideQuest = questData[1];

                    int index = journal.indexOf(questName);

                    if (index != -1 && !journal.contains(sideQuest)) {

                        journal.add(index + 1, sideQuest);
                    }
                    break;

                case "Renew":
                    if (journal.contains(tokens[1])){

                        journal.remove(tokens[1]);
                        journal.add(tokens[1]);
                    }
                    break;
            }

        }

        System.out.println(String.join(", ", journal));
    }
}
