import java.util.Scanner;

public class alcoholMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double whiskeyPrice = Double.parseDouble(scanner.nextLine());

        double beer = Double.parseDouble(scanner.nextLine());
        double wine = Double.parseDouble(scanner.nextLine());
        double brandy = Double.parseDouble(scanner.nextLine());
        double whiskey = Double.parseDouble(scanner.nextLine());

        double brandyPrice = whiskeyPrice / 2;
        double winePrice = brandyPrice * 0.6;
        double beerPrice = brandyPrice * 0.2;

        double beerSum = beer * beerPrice;
        double wineSum = wine * winePrice;
        double brandySum = brandy * brandyPrice;
        double whiskeySum = whiskey * whiskeyPrice;

        double all = beerSum + wineSum + brandySum + whiskeySum;

        System.out.printf("%.2f", all);

    }
}
