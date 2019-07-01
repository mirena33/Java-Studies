package GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayCreator {
    public static <T> T[] create(int length, T item) {

        List<T> asd = new ArrayList<>(length);

        for (int i = 0; i < asd.size(); i++) {
            asd.add(item);
        }

        return (T[]) asd.toArray();
    }

    // THE WAY TO DO IT!!:

    public static <T> T[] create(Class<T> tClass, int length, T item) {
        T[] o = (T[]) Array.newInstance(tClass, length);

        for (int i = 0; i < o.length; i++) {
            o[i] = item;
        }

        return o;
    }
}
