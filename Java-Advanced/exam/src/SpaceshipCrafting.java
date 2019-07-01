import java.util.*;

public class SpaceshipCrafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputLiquids = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        int[] inputPhysicalItem = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();

        for (int i = 0; i < inputLiquids.length; i++) {
            liquidsQueue.offer(inputLiquids[i]);
        }

        ArrayDeque<Integer> physicalItemsStack = new ArrayDeque<>();

        for (int i = 0; i < inputPhysicalItem.length; i++) {
            physicalItemsStack.push(inputPhysicalItem[i]);
        }


        int glass = 25;
        int glassCount = 0;

        int aluminium = 50;
        int aluminiumCount = 0;

        int lithium = 75;
        int lithiumCount = 0;

        int carbonFiber = 100;
        int carbonCount = 0;


        while (!liquidsQueue.isEmpty() && !physicalItemsStack.isEmpty()) {
            int liquid = liquidsQueue.poll();
            int physical = physicalItemsStack.pop();

            int sum = liquid + physical;

            if (sum == glass) {
                glassCount++;
            } else if (sum == aluminium) {
                aluminiumCount++;
            } else if (sum == lithium) {
                lithiumCount++;
            } else if (sum == carbonFiber) {
                carbonCount++;
            } else {
                physical = physical + 3;
                physicalItemsStack.push(physical);
            }
        }

        if (glassCount != 0 && aluminiumCount != 0 && lithiumCount != 0 && carbonCount != 0) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            for (int i = 0; i < liquidsQueue.size(); i++) {

                    System.out.print(liquidsQueue.poll() + ", ");
            }

            if (liquidsQueue.size() == 1) {
                System.out.printf("%d%n", liquidsQueue.poll());
            }
        }

        if (physicalItemsStack.isEmpty()){
            System.out.println("Physical items left: none");
        }else {
            System.out.print("Physical items left: ");
            for (int i = 0; i < physicalItemsStack.size(); i++) {

                    System.out.print(physicalItemsStack.pop() + ", ");

            }
            if (physicalItemsStack.size() == 1){
                System.out.printf("%d%n", physicalItemsStack.pop());
            }
        }


        System.out.println(String.format("Aluminium: %d%n" +
                "Carbon fiber: %d%n" +
                "Glass: %d%n" +
                "Lithium: %d", aluminiumCount, carbonCount, glassCount, lithiumCount));
    }
}
