package MyList;

import Interface.GBLinkedLists;

import java.util.Arrays;
import java.util.Iterator;

public class GBLinkedList<T> implements GBLinkedLists<T> {
    private T[] values;

    public GBLinkedList() {
        this.values = ((T[]) new Object[0]);
    }
    public GBLinkedList(T[] values) {
        this.values = values;
    }

    @Override
    public boolean addFirst(T t) {
        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 1, temp.length);
            values[0] = t;
            return true;
        } catch (ClassCastException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    @Override
    public boolean addLast(T t) {
        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = t;
            return true;
        } catch (ClassCastException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(values);
    }

    @Override
    public String toString() {
        return "GBLinkedList{" +
                "values=" + Arrays.toString(values) +
                '}' + '\n';
    }
}
