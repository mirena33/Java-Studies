import java.util.*;

public class companyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, List<String>> employeeInfo = new LinkedHashMap<>();

        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = input.split(" -> ");

            String company = data[0];
            String employeeID = data[1];

           employeeInfo.putIfAbsent(company, new ArrayList<>());

           if (!employeeInfo.get(company).contains(employeeID)){
               employeeInfo.get(company).add(employeeID);
           }


        }

        employeeInfo
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey)) // (n1,n2) -> n1.getKey().compareTo(n2.getKey())
                .forEach(e-> {
                    System.out.println(e.getKey());

                    e.getValue().forEach(id -> System.out.println(String.format("-- %s", id)));
                });
    }
}
