import java.util.Scanner;

public class travelling {


    public static void main(String[] main){
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            String country = scanner.nextLine();
            if(country.equals("End"))
            {
                break;
            }
            double budget = Double.parseDouble(scanner.nextLine());
            double sum = 0;
            while(budget > sum){
                double money = Double.parseDouble(scanner.nextLine());
                sum += money;
                money++;
            }
            System.out.printf("Going to %s!\n", country);
        }
    }
}