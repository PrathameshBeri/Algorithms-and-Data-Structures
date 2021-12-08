package Graphs.ADTs.Graphs;

import java.util.Iterator;

public class TestDFS {

    TestGraph testGraph;
    Boolean[] visited;
    Integer[] path;

    TestDFS(TestGraph test){

        testGraph = test;
        visited = new Boolean[testGraph.getVertices()];
        path = new Integer[testGraph.getVertices()];
    }

    void depthFirstSearch(int from, int to){
        depthFirstSearchHelper(from);
    }

    void depthFirstSearchHelper(int from){
        visited[from] = true;
        for (Iterator<Integer> it = testGraph.getNeighbours(from).getAll(); it.hasNext(); ) {
            int i = it.next();

            if(!visited[i]){
                depthFirstSearchHelper(i);
                path[i] = from;
            }
        }

    }
}
