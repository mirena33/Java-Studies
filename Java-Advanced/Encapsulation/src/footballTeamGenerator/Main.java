package footballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Team> teams = new HashMap<>();


        while (!input.equals("END")) {
            String[] tokens = input.split(";");
            String command = tokens[0];

            try {

                switch (command) {
                    case "Team":
                        teams.putIfAbsent(tokens[1], new Team(tokens[1]));
                        break;

                    case "Add":
                        if (teams.containsKey(tokens[1])) {
                            Player player = new Player(tokens[2],
                                    Integer.parseInt(tokens[3]),
                                    Integer.parseInt(tokens[4]),
                                    Integer.parseInt(tokens[5]),
                                    Integer.parseInt(tokens[6]),
                                    Integer.parseInt(tokens[7]));

                            teams.get(tokens[1]).addPlayer(player);
                        } else {
                            System.out.println("Team " + tokens[1] + " does not exist.");
                        }
                        break;

                    case "Remove":
                        if (teams.get(tokens[1]).hasPlayer(tokens[2])) {
                            teams.get(tokens[1]).removePlayer(tokens[2]);
                        } else {
                            System.out.println("Player " + tokens[2] + " is not in " + tokens[1] + " team.");
                        }
                        break;

                    case "Rating":
                        if (teams.containsKey(tokens[1])) {
                            int rating = (int)Math.round(teams.get(tokens[1]).getRating());

                            System.out.println(tokens[1] + " - " + rating);

                        } else {
                            System.out.println("Team " + tokens[1] + " does not exist.");
                        }
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            input = scanner.nextLine();
        }

    }
}
