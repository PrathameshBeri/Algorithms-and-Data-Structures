package ADTs.EdgeWeightedDigraph;

import ADTs.Bag;
import ADTs.MST.Edge;

import java.util.Iterator;

public class EdgeWeightedDigraph {

    private int vertices;
    private Bag<DirectedEdge>[] adjacencyList;


    public EdgeWeightedDigraph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new Bag<DirectedEdge>();
        }
    }

    public void addEdge(DirectedEdge e) throws Exception {
        if (this.adjacencyList == null)
            throw new Exception("Graph not initialised");
        int vertex = e.getFrom();
        adjacencyList[vertex].addItem(e);
    }

    public Iterator<DirectedEdge> getEdges(int vertex) {

        return adjacencyList[vertex].getAll();
    }

    public int getVertices() {
        return vertices;
    }

}


