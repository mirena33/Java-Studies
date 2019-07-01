import java.util.Scanner;

public class coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double change = Double.parseDouble(scanner.nextLine());
        int count = 0;
        int lv = Integer.parseInt(String.format("%.0f", Math.floor(change)));
        int stotinki = Integer.parseInt(String.format("%.0f,", change * 100)) - 100 *lv;

        while (lv > 0) {
            if (lv >= 2) {
                lv -=2;
                count++;
            } else if (lv >= 1) {
                lv--;
                count++;
            }
        }
while (stotinki > 0) {
    if (stotinki >= 50) {
        stotinki -= 50;
        count++;
    } else if (stotinki >= 20) {
        stotinki -= 20;
        count++;
    } else if (stotinki >= 10) {
        stotinki -= 10;
        count++;
    } else if (stotinki >= 5) {
        stotinki -= 5;
        count++;
    } else if (stotinki >= 2) {
        stotinki -= 2;
        count++;
    } else if (stotinki >= 1) {
        stotinki -= 1;
        count++;
    }
}

        System.out.println(count);

    }
}
