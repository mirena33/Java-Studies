import java.util.Scanner;

public class reversedArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        for (int i = 0; i < words.length / 2; i++) { // /2, zashtoto smenqme po 2 elementa na iteraciq
            String temp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = temp;

        }

     /*
       Another solution:
       for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }

         */


        for (String word : words) {
            System.out.print(word + " ");

        }

        // another print solution: System.out.println(String.join(" ", words));
    }
}
