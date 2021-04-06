package ADTs.MST;

import ADTs.Bag;

import java.util.Iterator;

public class EdgeWeightedGraph {

    private int vertices;
    private Bag<Edge>[] adjacencyList;


    public EdgeWeightedGraph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new Bag<Edge>();
        }
    }

    public void addEdge(Edge e) throws Exception {
        if (this.adjacencyList == null)
            throw new Exception("Graph not initialised");
        int vertex = e.either();
        adjacencyList[vertex].addItem(e);
        adjacencyList[e.other(vertex)].addItem(e);
    }

    public Iterator<Edge> getEdges(int vertex) {

        return adjacencyList[vertex].getAll();
    }

    public int getVertices(){
        return vertices;
    }

}
