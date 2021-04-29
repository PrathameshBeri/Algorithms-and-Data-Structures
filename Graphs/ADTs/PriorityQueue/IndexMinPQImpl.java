package ADTs.PriorityQueue;

public class IndexMinPQImpl<Key extends Comparable<Key>> implements IndexMinPQ {
    Key[] keys;     //The actual keys to be stored
    int[] pq;       //The binary heap containing the priority queue and the indexes.
    int[] qp;      //The location for each index i.e. the array index is the index for pq and the actual
    //content of the array qp shows the location on the pq.
    int n;


    IndexMinPQImpl(int n) {
        keys = (Key[]) new Comparable[n + 1];
        pq = new int[n + 1];
        qp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            qp[i] = -1;
        }

    }

    @Override
    public void insert(int k, Comparable N) {
        qp[k] = k;
        n++;
        keys[k] = (Key) N;
        pq[n] = k;
        swim(n);
    }

    @Override
    public void change(int k, Comparable N) {
        int index = qp[k];
        keys[k] = (Key) N;
        sink(index);
        swim(index);

    }

    @Override
    public boolean contains(int k) {
        return qp[k] != -1;
    }

    @Override
    public void delete(int k) {
        int index = qp[k];
        exchg(index, n--);
        swim(k);
        sink(k);
        qp[k] = -1;
        pq[n+1] = -1;
        keys[k] = null;
    }

    @Override
    public Comparable min() {
        return keys[pq[1]];
    }

    @Override
    public int minIndex() {
        return pq[1];
    }

    @Override
    public int delMin() {
        int min = pq[1]; //retrieve the minimum key
        //null the key
        exchg(1, --n);
        sink(1);
        keys[min] = null;
        qp[min] = -1;
        pq[n+1] = -1;
        return min;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }


    public void sink(int loc) {

        while (2 * loc <= n) {
            int j = 2 * loc;
            if (j < n && less(j, j + 1)) j++;
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

        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    public void exchg(int k, int j) {
        int temp = pq[k];
        pq[k] = pq[j];
        pq[j] = temp;
        qp[pq[k]] = k;
        qp[pq[j]] = j;
    }

}
