import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ClubParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hallCapacity = Integer.parseInt(scanner.nextLine());

        String[] input = scanner.nextLine().split("\\s+");

        Deque<String> hallsAndReservation = initializeStack(input, hallCapacity);

        Deque<String> halls = new ArrayDeque<>();
        Deque<Integer> currentHallReservations = new ArrayDeque<>();

        int currentHallCapacity = 0;

        while (!hallsAndReservation.isEmpty()) {
            String currentElement = hallsAndReservation.pop();

            if (Character.isDigit(currentElement.charAt(0))) {
                int reservation = Integer.parseInt(currentElement);

                if (currentHallCapacity + reservation > hallCapacity) {

                    printHall(halls, currentHallReservations);
                    currentHallCapacity = 0;
                }

                if (halls.isEmpty()){
                    continue;
                }

                currentHallReservations.offer(reservation);
                currentHallCapacity += reservation;
            } else {

                halls.offer(currentElement);
            }
        }
    }

    private static void printHall(Deque<String> halls, Deque<Integer> currentHallReservations) {
        System.out.print(halls.poll() + " -> ");

        while (!currentHallReservations.isEmpty()) {

            if (currentHallReservations.size() == 1) {
                System.out.println(currentHallReservations.poll());
            } else {
                System.out.print(currentHallReservations.poll() + ", ");
            }
        }

    }

    private static Deque<String> initializeStack(String[] input, int hallCapacity) {

        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }

        return stack;
    }
}
