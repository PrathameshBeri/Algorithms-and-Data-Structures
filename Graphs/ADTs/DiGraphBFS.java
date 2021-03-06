package ADTs;

import java.util.Iterator;

public class DiGraphBFS {
    boolean[] visited;
    int[] edgeTo;
    DiGraph graph;
    int vertices;

    DiGraphBFS(DiGraph graph) {
        this.graph = graph;
        vertices = graph.vertices;
        visited = new boolean[vertices];
        edgeTo = new int[vertices];
    }


    void breadthFirstSearch(int node) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(node);
        visited[node] = true;
        edgeTo[node] = node;
        while (!queue.isEmpty()) {
            int n = queue.dequeue();
            for (Iterator<Integer> it = graph.getIteratorForVertex(n); it.hasNext(); ) {
                int ver = it.next();
                if (!visited[ver]) {
                    queue.enqueue(ver);
                    visited[ver] = true;
                    edgeTo[ver] = n;
                }
            }

        }

    }

    void clearBFSResults() {
        visited = new boolean[vertices];
        edgeTo = new int[vertices];
    }

}
