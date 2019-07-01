import java.util.Scanner;

public class oldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bookName = scanner.nextLine();
        int capacity = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        while (capacity > 0) {
            String newBook = scanner.nextLine();


            if (newBook.equals(bookName)) {
                System.out.printf("You checked %d books and found it.", counter);
                return;
            }
            counter++;
            capacity--;

        }
        System.out.printf("The book you search is not here!%n");
        System.out.printf("You checked %d books.", counter);

    }
}

