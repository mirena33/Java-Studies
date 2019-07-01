import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class softUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine().split("\\s*,\\s*"))
                .collect(Collectors.toList());

        String input = "";

        while (!"course start".equals(input = scanner.nextLine())) {
            String[] commands = input.split(":");

            switch (commands[0]) {
                case "Add":

                    if (!isExistent(commands[1], schedule)) {
                        schedule.add(commands[1]);
                    }

                    break;
                case "Insert":
                    int index = Integer.parseInt(commands[2]);

                    if (index >= 0 && index < schedule.size()) {

                        if (!isExistent(commands[1], schedule)) {

                            schedule.add(index, commands[1]);
                        } else {
                            break;
                        }
                    }

                    break;

                case "Remove":

                    if (isExistent(commands[1], schedule)) {
                        schedule.remove(commands[1]);

                        if (schedule.contains(commands[1] + "-Exercise")) {
                            schedule.remove(commands[1] + "-Exercise");
                        }
                    }


                    break;

                case "Swap":

                    if (isExistent(commands[1], schedule) && isExistent(commands[2], schedule)) {

                        int firstIndex = schedule.indexOf(commands[1]);
                        int secondIndex = schedule.indexOf(commands[2]);

                        schedule.set(firstIndex, commands[2]);


                        if (schedule.contains(commands[2] + "-Exercise")) {

                            schedule.set(firstIndex, commands[2]);

                            schedule.remove(commands[2] + "-Exercise");
                            schedule.add(firstIndex + 1, commands[2] + "-Exercise");

                            schedule.set(secondIndex + 1, commands[1]);

                        } else {

                            schedule.set(secondIndex, commands[1]);
                        }

                        if (schedule.contains(commands[1] + "-Exercise")) {

                            schedule.remove(commands[1] + "-Exercise");
                            schedule.add(secondIndex + 1, commands[1] + "-Exercise");
                        }

                    }

                    break;

                case "Exercise":

                    if (isExistent(commands[1], schedule) && !(schedule.contains(commands[1] + "-Exercise"))) {

                        int currentIndex = schedule.indexOf(commands[1]);
                        schedule.add(currentIndex + 1, commands[1] + "-Exercise");


                    } else if (!(isExistent(commands[1], schedule)) && !(schedule.contains(commands[1] + "-Exercise"))) {

                        schedule.add(commands[1]);
                        schedule.add(commands[1] + "-Exercise");
                    }
                    break;
            }

        }

        for (int i = 0; i < schedule.size(); i++) {
            System.out.printf("%d.%s\n", i + 1, schedule.get(i));
        }
    }

    static boolean isExistent(String lessonTitle, List<String> schedule) {

        for (int i = 0; i < schedule.size(); i++) {
            if (schedule.get(i).equals(lessonTitle)) {

                return true;
            }
        }
        return false;
    }

}
