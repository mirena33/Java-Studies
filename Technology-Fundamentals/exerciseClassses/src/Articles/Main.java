package Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(", ");

        int n = Integer.parseInt(scanner.nextLine());

        String title = data[0];
        String content = data[0];
        String author = data[0];

        Article article = new Article(title, content, author);

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(": ");

            String command = input[0];

            switch (command) {
                case "Edit":
                    article.edit(input[1]);
                    break;

                case "ChangeAuthor":
                    article.changeAuthor(input[1]);
                    break;

                case "Rename":
                    article.rename(input[1]);
                    break;
            }
        }
        System.out.println(article);
    }
}
