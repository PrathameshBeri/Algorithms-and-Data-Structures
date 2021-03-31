package ADTs;

import java.util.Iterator;
import java.util.Stack;

public class DFSTopologicalSort {

    Stack<Integer> postOrder;
    DiGraph graph;
    boolean[] visited;

    DFSTopologicalSort(DiGraph graph) {
        this.graph = graph;
        postOrder = new Stack<>();
        visited = new boolean[graph.vertices];
    }

    void createTopologicalSort() {

        topologicalSortHelper(0);

    }

    void topologicalSortHelper(int e) {

        for (int i = e; i < graph.vertices; i++) {
            if (!visited[i]) {
                    depthFirstSearch(graph, i);
            }
        }
    }

    void depthFirstSearch(DiGraph g, Integer vertex){
        visited[vertex] = true;
        for (Iterator it = g.getIteratorForVertex(vertex); it.hasNext(); ) {
            int i = (int)it.next();
            if(!visited[i]){
                depthFirstSearch(graph, i);
            }
        }
        postOrder.push(vertex);
    }

    Iterable<Integer> getPostOrder() {
        return postOrder;
    }

}
