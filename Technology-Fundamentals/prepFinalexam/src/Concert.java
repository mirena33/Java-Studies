import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> bandsWithMembers = new LinkedHashMap<>();
        Map<String, Integer> bandsWithPlayedTime = new LinkedHashMap<>();

        int totalTime = 0;

        String input = "";

        while (!"start of concert".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\;\\s");

            String command = data[0];
            String bandName = data[1];

            if (command.equals("Add")) {

                if (!bandsWithMembers.containsKey(bandName)) {
                    bandsWithMembers.put(bandName, new ArrayList<>());
                    bandsWithPlayedTime.put(bandName, 0);
                }

                String[] bandMembers = data[2].split("\\,\\s");

                for (int i = 0; i < bandMembers.length; i++) {
                    if (!bandsWithMembers.get(bandName).contains(bandMembers[i])) {
                        bandsWithMembers.get(bandName).add(bandMembers[i]);
                    }
                }
            } else if (command.equals("Play")) {

                if (!bandsWithPlayedTime.containsKey(bandName)) {
                    bandsWithPlayedTime.put(bandName, 0);
                    bandsWithMembers.put(bandName, new ArrayList<>());
                }
                int playTime = Integer.parseInt(data[2]);
                totalTime += playTime;

                bandsWithPlayedTime.put(bandName, bandsWithPlayedTime.get(bandName) + playTime);


            }
        }

        String requestedBand = scanner.nextLine();

        System.out.println("Total time: " + totalTime);

        bandsWithPlayedTime
                .entrySet()
                .stream()
                .sorted((e1,e2) -> {
                    int sort = Integer.compare(e2.getValue(), e1.getValue());
                    if (sort == 0){
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;

                })
                .forEach(band ->{
                    System.out.println(String.format("%s -> %d", band.getKey(), band.getValue()));
                });

        System.out.println(requestedBand);

        bandsWithMembers.get(requestedBand).forEach(band -> System.out.println(String.format("=> %s", band)));
    }
}
