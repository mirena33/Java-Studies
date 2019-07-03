package TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(scanner.nextLine());

        TrafficLight[] lights = new TrafficLight[input.length];

        for (int i = 0; i < input.length; i++) {
            lights[i] = TrafficLight.valueOf(input[i]);
        }

        TrafficLight[] lightValues = {TrafficLight.RED, TrafficLight.GREEN, TrafficLight.YELLOW};
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            for (int i = 0; i < lights.length; i++) {

                if (lights[i].ordinal() == 2) {
                    lights[i] = TrafficLight.RED;
                }else {
                    lights[i] = lightValues[lights[i].ordinal() + 1];
                }

             sb.append(lights[i].toString()).append(" ");
            }

            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString());

    }
}
