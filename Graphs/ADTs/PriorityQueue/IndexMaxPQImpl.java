package ADTs.PriorityQueue;

public class IndexMaxPQImpl<Key extends Comparable<Key>> implements IndexMaxPQ {

    Key[] keys;
    int[] pq;
    int[] qp;
    int n;

    public IndexMaxPQImpl(int n) {
        keys = (Key[]) new Comparable[n + 1];
        pq = new int[n + 1];
        qp = new int[n + 1];
        this.n = n;
        for (int i = 0; i <= n; i++) {
            qp[i] = -1;
        }

    }


    @Override
    public void insert(int k, Comparable N) {

        qp[k] = k;
        keys[k] = (Key) N;
        pq[++n] = k;
        swim(n);

    }

    @Override
    public void change(int k, Comparable N) {

        //validate key first, this should only happen if the key actually exists

        keys[k] = (Key) N;
        sink(pq[qp[k]]);
        swim(pq[qp[k]]);

    }

    @Override
    public boolean contains(int k) {
        //first validate if the int k falls within the range
        return qp[k] != -1;
    }

    @Override
    public void delete(int k) {
        //first validate if the k index exists
        //algo - swap the last element and the index to be deleted. Then safely delete the index and adjust the new key
        //edge case - delete the last index. In this case the algo is very strghtforward

        exchg(qp[k], n);
        n--;
        swim(k);
        sink(k);
        qp[k] = -1;
        keys[k] = null;


    }

    @Override
    public Comparable max() {
        return keys[pq[1]];
    }

    @Override
    public int minIndex() {
        return 0;
    }

    @Override
    public int delMax() {
        //First validate if not an empty queue;

        int index = qp[pq[1]]; //max item will be stored at 1;
        exchg(1, n--);
        sink(1);
        keys[index] = null;
        qp[index] = -1;
        return index;

    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }


    public void sink(int k) {
        while (2 * k < n) {
            int j = 2 * k;
            if (j < n && more(j + 1, j)) j++;
            if (more(j + 1, k)) break;
            exchg(k, j);
            k = j;

        }

    }


    public void swim(int k) {

        while (k / 2 > 1 && more(k, k / 2)) {

            exchg(k, k / 2);
            k = k / 2;
        }

    }

    public void exchg(int i, int j) {
        int k = pq[i];
        pq[i] = pq[j];
        pq[j] = k;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public boolean more(int i, int j) {

        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }
}
