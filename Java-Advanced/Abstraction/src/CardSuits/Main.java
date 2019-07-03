package CardSuits;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ranks[] cardSuits = Ranks.values();

        System.out.println("Card Ranks:");

        for (Ranks value : cardSuits) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    value.ordinal(),
                    value));
        }
    }
}
