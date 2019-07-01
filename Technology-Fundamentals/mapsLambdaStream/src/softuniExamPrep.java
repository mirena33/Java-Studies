import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class softuniExamPrep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, Map<String, Integer>> studentsInfo = new LinkedHashMap<>();

        while (!"exam finished".equals(input = scanner.nextLine())) {
            String[] data = input.split("-");

            if (data[1].equals("banned")) {

            } else {
                String username = data[0];
                String language = data[1];
                int points = Integer.parseInt(data[2]);

                if (!studentsInfo.containsKey(username)){
                    studentsInfo.put(username, new LinkedHashMap<>());
                    studentsInfo.get(username).put(language, points);
                } else {
                  studentsInfo.get(username).put(studentsInfo.get(username) + language, points);
                }
            }


        }
    }
}
