import java.util.Scanner;

public class hotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int overnights = Integer.parseInt(scanner.nextLine());

        double priceApartment = 0.0;
        double priceStudio = 0.0;
        double totalApartment = 0.0;
        double totalStudio = 0.0;

        switch (month) {
            case "May":
                if (overnights <= 7) {
                    priceStudio = 50;
                    priceApartment = 65;
                }else if (overnights > 14) {
                    priceStudio = 50 - (50 * 0.30);
                    priceApartment = 65 -(65 * 0.10);
                }
                 else if (overnights > 7) {
                    priceStudio = 50 - (50 * 0.05);
                    priceApartment = 65;
                }
                totalStudio = priceStudio * overnights;
                totalApartment = priceApartment * overnights;


                break;

            case "June":
                if (overnights <= 14) {
                    priceStudio = 75.20;
                    priceApartment = 68.70;
                }
                else if (overnights > 14) {
                    priceStudio = 75.20- (75.20 * 0.20);
                    priceApartment = 68.70 - (68.70 * 0.10);
                }
                totalStudio = priceStudio * overnights;
                totalApartment = priceApartment * overnights;

                break;

            case "July":
                priceStudio = 76;
                priceApartment = 77;
                if (overnights > 14) {
                    priceApartment = 77 - (77 * 0.10);
                }
                totalApartment = priceApartment * overnights;
                totalStudio = priceStudio * overnights;

                break;

            case "August":
                priceStudio = 76;
                priceApartment = 77;
                if (overnights > 14) {
                    priceApartment = 77 - (77 * 0.10);
                }
                totalApartment = priceApartment * overnights;
                totalStudio = priceStudio * overnights;
                break;

            case "September":

                if (overnights <= 14) {
                    priceStudio = 75.20;
                    priceApartment = 68.70;
                }
                else if (overnights > 14) {
                    priceStudio = 75.20- (75.20 * 0.20);
                    priceApartment = 68.70 - (68.70 * 0.10);
                }
                totalStudio = priceStudio * overnights;
                totalApartment = priceApartment * overnights;

                break;

            case "October":
                if (overnights <= 7) {
                    priceStudio = 50;
                    priceApartment = 65;
                }else if (overnights > 14) {
                    priceStudio = 50 - (50 * 0.30);
                    priceApartment = 65 -(65 * 0.10);
                }
                else if (overnights > 7) {
                    priceStudio = 50 - (50 * 0.05);
                    priceApartment = 65;
                }
                totalStudio = priceStudio * overnights;
                totalApartment = priceApartment * overnights;

                break;
        }

        System.out.printf("Apartment: %.2f lv.%n", totalApartment);
        System.out.printf("Studio: %.2f lv.", totalStudio);



    }
}
