package AdvertisementMessage;

import java.util.Scanner;

public class meesageMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Message message = new Message();

        for (int i = 0; i < n; i++) {

            String random = message.randomMessage();

            System.out.println(random);
        }
    }
}
