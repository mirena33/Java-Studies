import java.util.Scanner;

public class exercise {

    public static void main(String[] args) {

        //films per page

        Scanner inputReader = new Scanner((System.in));

       double allfilms = Double.parseDouble(inputReader.nextLine());
       double filmsPerPage = Double.parseDouble(inputReader.nextLine());
       double pages = Math.ceil(allfilms/filmsPerPage);

        System.out.printf("Pages needed %f", pages);
    }
}
