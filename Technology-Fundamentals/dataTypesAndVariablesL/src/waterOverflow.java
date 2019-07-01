import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class waterOverflow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int sum = 0;
        int capacity = 255;

        for (int i = 0; i < n; i++) {
            int quantityInput = Integer.parseInt(reader.readLine());

            if (quantityInput + sum > capacity) {
                System.out.println("Insufficient capacity!");
            } else {
                sum += quantityInput;
            }


        }


        System.out.println(sum);
    }
}
