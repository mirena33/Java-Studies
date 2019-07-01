import java.util.Scanner;

public class xercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String name = scanner.nextLine();

        String result="";

        for(int i=name.length()- 1; i >= 0; i--) {
            result = result + name.charAt(i);
        }
        System.out.println(result);
    }
}
