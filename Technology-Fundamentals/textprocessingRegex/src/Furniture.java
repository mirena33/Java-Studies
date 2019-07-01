import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">>+([A-Z{0,}a-z]+)+<<([\\d+]*\\.*[\\d+]+)!([\\d+]+)";
        Pattern pattern = Pattern.compile(regex);

        double totalMoney = 0.0;
        List<String> furniture = new ArrayList<>();

        String input = "";

        while (!"Purchase".equals(input = scanner.nextLine())) {


            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                furniture.add(matcher.group(1));
                double currentPrice = Double.parseDouble(matcher.group(2));
                int currentQuantity = Integer.parseInt(matcher.group(3));

                totalMoney += currentPrice * currentQuantity;

            }

        }

            System.out.println("Bought furniture:");
            System.out.println(String.join("\n", furniture));
            System.out.printf("Total money spend: %.2f", totalMoney);

    }
}
