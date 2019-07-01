import java.util.Scanner;

public class addAndSubstract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());


        int finalSum = sum(firstNum, secondNum);
        System.out.println(substract(thirdNum, finalSum));
    }

    static int sum(int first, int second) {

        return first + second;
    }

    static int substract(int third, int finalSum) {

        return finalSum - third;
    }
}
