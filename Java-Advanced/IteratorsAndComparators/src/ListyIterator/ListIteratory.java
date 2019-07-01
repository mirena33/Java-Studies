package ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListIteratory implements Iterable<String> {

    private List<String> data;
    private int index;

    public ListIteratory(List<String> data) {
        this.data = data;
        this.index = 0;
    }

    public boolean move() {
        if (this.hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public void PrintAll(){
        for (String str : this) {
            System.out.print(str + " ");
        }

    }

    public boolean hasNext() {
        return this.index < this.data.size() - 1;
    }

    public String print() throws IllegalAccessException {
        if (this.data.size() == 0) {
            throw new IllegalAccessException("Invalid Operation!");
        }
        return this.data.get(this.index);
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }

            @Override
            public String next() {
                String element = data.get(this.index);
                this.index++;
                return element;
            }
        };
    }
}
