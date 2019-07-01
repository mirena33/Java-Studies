package Articles2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader
                (new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(", ");

            Article article = new Article(input[0], input[1], input[2]);

            articles.add(article);

            if (i == n - 1) {
                String command = reader.readLine();

                switch (command) {
                    case "title":

                        articles.stream().sorted((p1, p2) -> p1.getTitle().compareTo(p2.getTitle()))
                                .forEach(e -> {
                                    System.out.println(e.toString());
                                });

                        break;

                    case "content":

                        articles.stream().sorted((p1, p2) -> p1.getContent().compareTo(p2.getContent()))
                                .forEach(e -> {
                                    System.out.println(e.toString());
                                });

                        break;

                    case "author":

                        articles.stream().sorted((p1, p2) -> p1.getAuthor().compareTo(p2.getAuthor()))
                                .forEach(e -> {
                                    System.out.println(e.toString());
                                });

                        break;
                }
            }

        }


    }
}
