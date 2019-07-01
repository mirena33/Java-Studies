package GenericSwap;

import GenericBox.Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Box<String>> boxes = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String str = scanner.next();
            Box<String> box = new Box<>(str);

            boxes.add(box);
        }

        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();

//        swapElements(boxes, firstIndex, secondIndex);
//
//        for (Box box :
//                boxes) {
//            System.out.println(box.toString());
//        }
//    }
//
//    private static <T> void swapElements(List<Box<T>> boxes, int firstIndex, int secondIndex) {
//
//        Box temp = boxes.get(firstIndex);
//        boxes.set(firstIndex, boxes.get(secondIndex));
//        boxes.set(secondIndex, temp);
    }

}
