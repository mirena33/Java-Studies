import java.util.Scanner;

public class cookingFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        int bestTotalQuality = 0;
        double bestAverageQuality = 0;
        int fewestElements = Integer.MAX_VALUE;


        String[] bestBatch = new String[10];


        while (!"Bake It!".equals(input = scanner.nextLine())) {

            String[] inputData = input.split("#+");
            int[] batch = new int[inputData.length];


            for (int i = 0; i < batch.length; i++) {
                batch[i] = Integer.parseInt(inputData[i]);
            }
            int quality = 0;
            double averageQuality = 0;


            for (int i = 0; i < batch.length; i++) {

                quality += batch[i];
                averageQuality += (batch[i]) / (double) batch.length;
            }

                if (quality > bestTotalQuality) {

                    bestTotalQuality = quality;
                    bestAverageQuality = averageQuality;

                    bestBatch = inputData;

                }

                if (quality == bestTotalQuality && averageQuality == bestAverageQuality){

                    int elements = batch.length;

                    if (elements < fewestElements) {

                        fewestElements = elements;
                        bestBatch = inputData;
                    }

                }

                if (quality == bestTotalQuality) {

                    if (averageQuality > bestAverageQuality) {
                        bestBatch = inputData;
                    }

                }


        }

        System.out.println("Best Batch quality: " + bestTotalQuality);
        System.out.println(String.join(" ", bestBatch));


    }
}

