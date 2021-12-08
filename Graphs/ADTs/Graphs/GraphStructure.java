package ADTs.Graphs;


import ADTs.Bag;

import java.util.Iterator;

public class GraphStructure {

    int vertices;
    Bag<Integer>[] adjacencyMatrix;

    GraphStructure(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyMatrix[i] = new Bag<>();
        }
    }

    void addEdge(int fromEdge, int toEdge) {
        adjacencyMatrix[fromEdge].addItem(toEdge);
        adjacencyMatrix[toEdge].addItem(fromEdge);
    }

    Iterator getIteratorForVertex(int vertex) {
        return adjacencyMatrix[vertex].getAll();
    }

    void printGraphStructure() {
        int count = 0;
        for (Bag b : adjacencyMatrix) {
            System.out.print(count + " -> ");
            Iterator f = b.getAll();
            while (f.hasNext()) {
                System.out.print(" " + f.next());
            }
            count++;
            System.out.println();
        }
    }
}