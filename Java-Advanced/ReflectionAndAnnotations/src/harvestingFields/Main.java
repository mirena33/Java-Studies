package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Field[] fields = RichSoilLand.class.getDeclaredFields();

        while (!"HARVEST".equals(input = scanner.nextLine())) {

            if (input.equals("all")) {
                Arrays.stream(fields)
                        .forEach(field ->
                                System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),
                                        field.getType().getSimpleName(),
                                        field.getName()
                                ));
            } else {

                String finalInput = input;
                Arrays.stream(fields)
                        .filter(field -> Modifier.toString(field.getModifiers()).equals(finalInput))
                        .forEach(field ->
                                System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),
                                        field.getType().getSimpleName(),
                                        field.getName()
                                ));
            }

            /*ANOTHER SOLUTION:*/

//            switch (input) {
//                case "private":
//                    Arrays.stream(fields)
//                            .filter(field -> Modifier.isPrivate(field.getModifiers()))
//                            .forEach(field ->
//                                    System.out.printf("private %s %s%n", field.getType().getSimpleName(),
//                                            field.getName()
//                                    ));
//                    break;
//
//                case "public":
//                    Arrays.stream(fields)
//                            .filter(field -> Modifier.isPublic(field.getModifiers()))
//                            .forEach(field ->
//                                    System.out.printf("public %s %s%n", field.getType().getSimpleName(),
//                                            field.getName()
//                                    ));
//                    break;
//
//                case "protected":
//                    Arrays.stream(fields)
//                            .filter(field -> Modifier.isProtected(field.getModifiers()))
//                            .forEach(field ->
//                                    System.out.printf("protected %s %s%n", field.getType().getSimpleName(),
//                                            field.getName()
//                                    ));
//                    break;
//
//                case "all":
//                    Arrays.stream(fields)
//                            .forEach(field ->
//                                    System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),
//                                            field.getType().getSimpleName(),
//                                            field.getName()
//                                    ));
//                    break;
//            }
        }
    }
}
