package ADTs.EdgeWeightedDigraph;

import ADTs.DiGraph;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSortEW {

    Stack<Integer> postOrder;
    EdgeWeightedDigraph graph;
    boolean[] visited;

    TopologicalSortEW(EdgeWeightedDigraph graph) {
        this.graph = graph;
        postOrder = new Stack<>();
        visited = new boolean[graph.getVertices()];
    }

    void createTopologicalSort() {

        topologicalSortHelper(0);

    }

    void topologicalSortHelper(int e) {

        for (int i = e; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                depthFirstSearch(graph, i);
            }
        }
    }

    void depthFirstSearch(EdgeWeightedDigraph g, Integer vertex) {
        visited[vertex] = true;
        for (Iterator it = g.getEdges(vertex); it.hasNext(); ) {
            int i = (int) it.next();
            if (!visited[i]) {
                depthFirstSearch(graph, i);
            }
        }
        postOrder.push(vertex);
    }

    Iterable<Integer> getPostOrder() {
        return postOrder;
    }

}
