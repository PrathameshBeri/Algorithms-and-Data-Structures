package ADTs.PriorityQueue;

public interface PriorityQueue<T extends Comparable<T>> {

    void insert(T key);
    T delFirst();
    boolean isEmpty();
}
