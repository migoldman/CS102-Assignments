package utilities;

public interface SortedSet<T extends Comparable> {

    public boolean isEmpty();
    public T insert(T item);
    public T delete(T item);
    public T member(T item);
    public Queue<T> elements();
}
