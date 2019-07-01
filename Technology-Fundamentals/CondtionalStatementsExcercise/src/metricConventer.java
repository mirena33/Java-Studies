import java.util.Scanner;

public class metricConventer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        String inputValue = scanner.nextLine();
        String outputValue = scanner.nextLine();
        double result = 1.0;

        if (inputValue.equals("mm")) {
            result = number / 1000;
        } else if (inputValue.equals("cm")) {
            result = number / 100;
        } else if (inputValue.equals("mi")) {
            result = number / 0.000621371192;
        } else if (inputValue.equals("in")) {
            result = number / 39.3700787;
        } else if (inputValue.equals("km")) {
            result = number / 0.001;
        } else if (inputValue.equals("ft")) {
            result = number / 3.2808399;
        } else if (inputValue.equals("yd")) {
            result = number / 1.0936133;

        }
        else if (inputValue.equals("m")) {
            result = number;
        }
        if (outputValue.equals("mm")) {
            result = result * 1000;
        } else if (outputValue.equals("cm")) {
            result = result * 100;
        } else if (outputValue.equals("mi")) {
            result = result * 0.000621371192;
        } else if (outputValue.equals("in")) {
            result = result * 39.3700787;
        } else if (outputValue.equals("km")) {
            result = result * 0.001;
        } else if (outputValue.equals("ft")) {
            result = result * 3.2808399;
        } else if (outputValue.equals("yd")) {
            result = result * 1.0936133;
        }
        System.out.printf("%.8f", result);


    }
}
