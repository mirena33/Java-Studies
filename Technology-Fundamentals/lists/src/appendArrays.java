import java.util.Arrays;
        import java.util.Collections;
        import java.util.List;
        import java.util.Scanner;
        import java.util.stream.Collectors;

public class appendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> allNumbers = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        Collections.reverse(allNumbers);

        String output = allNumbers.toString().replaceAll("[\\[,\\]]", "").trim();

        output = output.replaceAll("\\s+", " ");

        System.out.println(output);
    }
}
