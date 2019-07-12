package ArrayListLab;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private static Random RANDOM;

    static {
        RANDOM = new Random();
    }

    public Object getRandomElement() {
        int index = RANDOM.nextInt(super.size());
        return super.remove(index);

    }
}
