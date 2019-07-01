import java.util.Scanner;

public class currencyConventer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = Double.parseDouble(scanner.nextLine());
        String currencyinput = scanner.nextLine();
        String currencyoutput = scanner.nextLine();

        if (currencyinput.equals("USD")) {

            sum = sum * 1.79549;

        } else if (currencyinput.equals("EUR")) {
            sum = sum * 1.95583;

        } else if (currencyinput.equals("GBP")) {
            sum = sum * 2.53405;
        }


        if (currencyoutput.equals("USD")) {
            sum = sum / 1.79549;
        } else if (currencyoutput.equals("EUR")) {
            sum = sum / 1.95583;
        } else if (currencyoutput.equals("GBP")) {

            sum = sum / 2.53405;
        }

        System.out.printf("%.2f %s", sum, currencyoutput);


    }
}
