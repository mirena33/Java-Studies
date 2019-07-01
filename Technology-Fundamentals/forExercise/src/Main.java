import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double oddSum = 0.0;
        double oddMin = 10000000000.0;
        double oddMax = -10000000000.0;
        double evenSum = 0.0;
        double evenMin = 10000000000.0;
        double evenMax = -10000000000.0;
        for (int i = 1; i <= n ; i++) {
            double num = Double.parseDouble(scanner.nextLine());

            if (i % 2 ==0){
                evenSum += num;
                if (num > evenMax){
                    evenMax = num;
                }
                if (num < evenMin) {
                    evenMin = num;
                }
            } else {
                oddSum += num;
                if (num > oddMax){
                    oddMax = num;
                }
                if (num < oddMin){
                    oddMin = num;
                }
            }
        }

        DecimalFormat dec = new DecimalFormat("#.##");

        System.out.println("OddSum="+ dec.format(oddSum));
        if (oddMin == 10000000000.0){
            System.out.println("OddMin=No");
        } else{
            System.out.println("OddMin="+ dec.format(oddMin));
        }
        if (oddMax == -10000000000.0){
            System.out.println("OddMax=No");
        } else {
            System.out.println("OddMax="+ dec.format(oddMax));
        }

        System.out.println("EvenSum="+ dec.format(evenSum));
        if (evenMin == 10000000000.0){
            System.out.println("EvenMin=No");
        } else {
            System.out.println("EvenMin="+ dec.format(evenMin));
        }
        if (evenMax == -10000000000.0){
            System.out.println("EvenMax=No");
        } else {
            System.out.println("EvenMax=" + dec.format(evenMax));
        }
    }
}