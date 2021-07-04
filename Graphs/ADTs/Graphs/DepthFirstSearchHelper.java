package ADTs.Graphs;

import java.util.Iterator;

public class DepthFirstSearchHelper {

    boolean[] visited;
    int[] edgeTo;
    GraphStructure graph;

    DepthFirstSearchHelper(GraphStructure graph) {
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
