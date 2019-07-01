import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ladyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

        int[] ladyBugs = new int[fieldSize];

        int[] ladyBugIndices = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(e -> e >= 0 && e < fieldSize)
                .toArray();


        for (int i = 0; i < ladyBugIndices.length; i++) {
            ladyBugs[ladyBugIndices[i]] = 1;

        }

        String input = "";

        while (!"end".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");

            int ladyBugIndex = Integer.parseInt(data[0]);
            String direction = data[1];
            int flyLength = Integer.parseInt(data[2]);

            if (ladyBugIndex >= 0 && ladyBugIndex < ladyBugs.length
                    && ladyBugs[ladyBugIndex] == 1) {

                ladyBugs[ladyBugIndex] = 0;

                while (true) {
                    switch (direction) {
                        case "left":
                            ladyBugIndex -= flyLength;
                            break;

                        case "right":
                            ladyBugIndex += flyLength;
                            break;

                    }

                    if (ladyBugIndex < 0 || ladyBugIndex >= fieldSize){
                        break;
                    }

                    if (ladyBugs[ladyBugIndex] == 1){
                        continue;
                    }

                    if (ladyBugs[ladyBugIndex] == 0){
                        ladyBugs[ladyBugIndex] = 1;
                        break;
                    }

                }
            }

        }

        System.out.println(Arrays.stream(ladyBugs)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" ")));
    }
}
