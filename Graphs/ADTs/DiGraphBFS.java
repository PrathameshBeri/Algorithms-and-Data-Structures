package ADTs;

import java.util.Iterator;

public class DiGraphBFS {

    boolean[] visited;
    int[] edgeTo;
    DiGraph graph;

    DiGraphBFS(DiGraph graph) {
        this.graph = graph;
        int vertices = graph.vertices;
        visited = new boolean[vertices];
        edgeTo = new int[vertices];
    }

    void depthFirstSearch(int e) {

        visited[e] = true;
        for (Iterator<Integer> it = this.graph.getIteratorForVertex(e); it.hasNext(); ) {
            int ee = it.next();
            if (!visited[ee]) {
                depthFirstSearch(ee);
                edgeTo[ee] = e;
            }
        }

    }
}
