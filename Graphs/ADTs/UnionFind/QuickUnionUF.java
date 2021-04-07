package ADTs.UnionFind;

public class QuickUnionUF {

    int[] nodes;


    QuickUnionUF(int n) {
        nodes = new int[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }
    }

    private int root(int i) {

        while (nodes[i] != i) {
            i = nodes[i];
        }
        return i;
    }

    public void union(int u, int v) {
        int r1 = root(u);
        int r2 = root(v);
        nodes[r1] = r2;
    }

    public boolean connected(int u, int v) {
        return root(u) == root(v);
    }
}
