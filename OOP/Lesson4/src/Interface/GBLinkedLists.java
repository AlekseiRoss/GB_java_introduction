package Interface;

public interface GBLinkedLists<T> extends Iterable<T> {
    boolean addFirst(T t);
    boolean addLast(T t);
    int size();
    T get(int index);
}
