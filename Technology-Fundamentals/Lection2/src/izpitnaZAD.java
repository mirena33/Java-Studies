import java.util.Scanner;

public class izpitnaZAD {

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);
        int length = Integer.parseInt(inputReader.nextLine());
        int width = Integer.parseInt(inputReader.nextLine());
        int height = Integer.parseInt(inputReader.nextLine());
        double percentage = Double.parseDouble(inputReader.nextLine());

        double volume = length * width * height;
        double allLiters = volume * 0.001;        // za da namerim Volume v kolko obshto litri
        percentage = percentage * 0.01;          //za da prevurnem 17 v procenti
        double result = allLiters * (1 - percentage);         // umnojavame obshtite litri po suotv procent SAMO voda
        System.out.printf("%.3f",result);
    }
}
