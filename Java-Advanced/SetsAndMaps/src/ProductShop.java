import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, Map<String, Double>> shop = new TreeMap<>();

        while (!"Revision".equals(input = scanner.nextLine())){
            String[] tokens = input.split(",\\s+");

            String shopName = tokens[0];
            String productName = tokens[1];
            Double productPrice = Double.parseDouble(tokens[2]);

            shop.putIfAbsent(shopName, new LinkedHashMap<>());
            shop.get(shopName).putIfAbsent(productName, productPrice);


        }

        shop.forEach((shopName, products) -> {
            System.out.println(shopName + "->");

            products.forEach((productName, productPrice) -> {
                System.out.println(String.format("Product: %s, Price: %.1f", productName, productPrice));
            });
        });
    }
}
