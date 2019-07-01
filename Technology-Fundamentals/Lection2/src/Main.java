import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        String firstName = inputReader.nextLine();
        String secondName = inputReader.nextLine();
        int age = Integer.parseInt(inputReader.nextLine());
        String town = inputReader.nextLine();

        System.out.printf("You are %s %s, a %d-years old person from %s.", firstName , secondName , age , town);
    }
}
