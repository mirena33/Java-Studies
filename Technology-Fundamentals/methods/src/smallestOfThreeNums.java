import java.util.Scanner;

public class smallestOfThreeNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int minElement = min(firstNum, secondNum);

        System.out.println(min(minElement, thirdNum));

    }


    static int min(int first, int second) {
        return Math.min(first, second);
    }
}
