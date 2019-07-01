import java.util.Scanner;

public class tailoringWorkshop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tables = Integer.parseInt(scanner.nextLine());
        double tablesLength = Double.parseDouble(scanner.nextLine());
        double tablesWidth = Double.parseDouble(scanner.nextLine());

        double tableClothArea = tables * (tablesLength + 2 * 0.3) * (tablesWidth + 2 * 0.30);
        double tableCoverArea = tables * (tablesLength / 2) * (tablesLength / 2);

        double USDprice = (tableClothArea * 7)  + (tableCoverArea * 9);
        double BGNprice = USDprice * 1.85;

        System.out.printf("%.2f USD%n", USDprice); // %n NOV RED
        System.out.printf("%.2f BGN", BGNprice);

    }
}
