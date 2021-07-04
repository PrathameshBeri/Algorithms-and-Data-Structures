package ADTs.Graphs;

import java.util.Iterator;
import java.util.Stack;

public class KosarajuSharir {

    Stack<Integer> postOrder;
    DiGraph graph;
    boolean[] visited;
    int[] id;

    KosarajuSharir(DiGraph graph) {
        this.graph = graph;
        postOrder = new Stack<>();
        visited = new boolean[graph.vertices];
        id = new int[graph.vertices];
    }


    void calculateKosarajuSharir() {
        DiGraph reverse = graph.reverseGraph();
        DFSTopologicalSort dfsTopologicalSort = new DFSTopologicalSort(reverse);
        dfsTopologicalSort.createTopologicalSort();
        for (int i : dfsTopologicalSort.postOrder) {
            if (!visited[i]) {
                depthFirstSearch(graph, i);
            }
        }
    }

    void depthFirstSearch(DiGraph g, Integer vertex) {
        visited[vertex] = true;
        for (Iterator it = g.getIteratorForVertex(vertex); it.hasNext(); ) {
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
