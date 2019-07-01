import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class softuniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> licenceRegister = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String command = data[0];
            String username = data[1];

            switch (command) {

                case "register":
                    String plateNumber = data[2];

                    if (licenceRegister.containsKey(username)) {

                        System.out.printf("ERROR: already registered with plate number %s\n", licenceRegister.get(username));

                    } else {
                        licenceRegister.put(username, plateNumber);
                        System.out.printf("%s registered %s successfully\n", username, plateNumber);
                    }

                    break;

                case "unregister":

                    if (!licenceRegister.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found\n", username);
                    } else {

                        licenceRegister.remove(username);
                        System.out.printf("%s unregistered successfully\n", username);
                    }
                    break;
            }

        }

    licenceRegister.forEach((key, value) -> System.out.println(
            String.format("%s => %s", key, value)
    ));
    }
}
