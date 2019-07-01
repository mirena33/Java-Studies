import java.util.Scanner;

public class MultiplyEvensbyOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Math.abs(Integer.parseInt(scanner.nextLine()));

        System.out.println(getMultipleEvensOdds(number));

    }

    static int getMultipleEvensOdds(int number){

        int evenSum = getSumOfEvenNumbers(number);
        int oddSum = getSumOfOddNumbers(number);

        return evenSum * oddSum;

    }

    static int getSumOfEvenNumbers(int number) {

        int evenDigitsSum = 0;

        while (number > 0) {

           int numberTemp = number % 10;

            if (numberTemp % 2 == 0){
                evenDigitsSum += numberTemp;

            }
            number = number / 10;
        }
        return evenDigitsSum;
    }

    static int getSumOfOddNumbers(int number) {

        int oddDigitsSum = 0;

        while (number > 0) {

            int numberTemp = number % 10;

            if (!(numberTemp % 2 == 0)){
                oddDigitsSum += numberTemp;

            }
            number = number / 10;
        }
        return oddDigitsSum;
    }
}
