package ADTs.PriorityQueue;

public interface IndexMaxPQ<Key extends Comparable<Key>> {

    void insert(int k, Key N);
    void change(int k, Key N);
    boolean contains(int k);
    void delete(int k);
    Key max();
    int minIndex();
    int delMax();
    boolean isEmpty();
    int size();

}
