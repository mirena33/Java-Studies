import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> participants = new LinkedHashMap<>();
        String[] strParticipants = scanner.nextLine().split(", ");

        Arrays.stream(strParticipants).forEach(n -> participants.put(n, 0));

        String input = "";

        while (!"end of race".equals(input = scanner.nextLine())) {

            StringBuilder sb = new StringBuilder();
            Pattern pattern = Pattern.compile("[A-Za-z]+");
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                sb.append(matcher.group());
            }

            if (participants.containsKey(sb.toString())) {

                pattern = Pattern.compile("\\d");
                matcher = pattern.matcher(input);

                while (matcher.find()) {
                    int digit = Integer.parseInt(matcher.group());
                    participants.put(sb.toString(), participants.get(sb.toString()) + digit);
                }
            }

        }

        int[] places = {1};

        participants
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(3)
                .forEach(
                        n -> {
                            switch (places[0]) {
                                case 1:
                                    System.out.print("1st place: ");
                                    break;
                                case 2:
                                    System.out.print("2nd place: ");
                                    break;
                                case 3:
                                    System.out.print("3rd place: ");
                                    break;
                            }
                            System.out.println(n.getKey());
                            places[0] += 1;
                        }
                );
    }
}
