import java.util.Scanner;

public class rageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headSetPrice = Double.parseDouble(scanner.nextLine());
        int trashedHeadSet = 0;
        double mousePrice = Double.parseDouble(scanner.nextLine());
        int trashedMouse = 0;
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        int trashedKeyboard = 0;
        double displayPrice = Double.parseDouble(scanner.nextLine());
        int trashedDisplay = 0;
        int displayCount=0;
        double rageExpenses = 0.0;

        for(int i = 1; i <= lostGames; i++)
        {
            if (i % 2 == 0)
            {
                trashedHeadSet++;
            }
            if (i % 3 == 0)
            {
                trashedMouse++;
            }
            if (i % 2 == 0 && i % 3 == 0)
            {
                trashedKeyboard++;
                if (trashedKeyboard % 2 == 0)
                {
                    displayCount = 1;
                }

            }

            if (trashedKeyboard % 2 == 0 && displayCount == 1)
            {
                trashedDisplay++;
                displayCount = 0;
            }
        }
        rageExpenses = (trashedHeadSet * headSetPrice)
                + (trashedMouse * mousePrice)
                + (trashedKeyboard * keyboardPrice)
                + (trashedDisplay * displayPrice);

        System.out.printf("Rage expenses: %.2f lv.", rageExpenses);
    }

    }

