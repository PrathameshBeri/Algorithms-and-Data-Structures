package ADTs.PriorityQueue;

public class PriorityQueueImpl<T extends Comparable<T>> implements PriorityQueue<T> {

    private T[] heap;
    private int k = 0;

    PriorityQueueImpl(int K) {

        heap = (T[]) new Comparable[K + 1];

    }


    public void sink(int loc) {

        while (2 * loc <= k) {
            int j = 2 * loc;
            if (j < k && less(j, j + 1)) j++;
            if (!less(loc, j)) break;
            exchg(loc, j);
            loc = j;
        }

    }

    ;

    public void swim(int k) {

        while (k > 1) {
            if (less(k / 2, k)) {
                exchg(k / 2, k);
                k = k / 2;
            }
        }
    }

    ;

    public boolean less(int i, int j) {

        return heap[i].compareTo(heap[j]) < 0;
    }

    public void exchg(int k, int j) {
        T temp = heap[k];
        heap[k] = heap[j];
        heap[j] = temp;

    }

    @Override
    public void insert(T key) {

        heap[++k] = key; //insert at the last position
        swim(k);        //swim up the tree if the new key is bigger than the parent
    }

    @Override
    public T delFirst() {
        T max = heap[1];  //maximum will be the first index
        exchg(1, k--); //replace with the last key, also decrease the last index
        heap[k + 1] = null; //remove the last key
        sink(1); // sink the newly placed key
        return max;
    }

    @Override
    public boolean isEmpty() {
        return k == 0;
    }
}
