package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Reflection reflection = new Reflection();
        Class<Reflection> reflectionClass = (Class<Reflection>) reflection.getClass();
        Method[] allDeclaredMethods = reflectionClass.getDeclaredMethods();

        Method[] getters = getMethodsStartWith("get", allDeclaredMethods);
        Method[] setters = getMethodsStartWith("set", allDeclaredMethods);
        Field[] fields = reflectionClass.getFields();

        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> {
                    System.out.println(String.format("%s must be private!", f.getName()));
                });

        Arrays.stream(getters)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> {
                    System.out.println(String.format("%s have to be public!", m.getName()));
                });

        Arrays.stream(setters)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> {
                    System.out.println(String.format("%s have to be private!", m.getName()));
                });
    }

    public static Method[] getMethodsStartWith(String with, Method[] methods) {
        return Arrays.stream(methods)
                .filter(m -> m.getName().startsWith(with))
                .toArray(Method[]::new);
    }
}
