package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        int power = CardRank.valueOf(rank).getValue() + CardSuit.valueOf(suit).getValue();

        System.out.printf("Card name: %s of %s; Card power: %d",
                rank,
                suit,
                power);
    }
}