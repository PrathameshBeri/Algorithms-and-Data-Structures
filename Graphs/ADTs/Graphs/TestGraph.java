package Graphs.ADTs.Graphs;

import ADTs.Bag;

import java.util.List;

public class TestGraph {

    private List<ADTs.Bag<Integer>> adjacencyMatrix;
    private int vertices;

    TestGraph(List<ADTs.Bag<Integer>> adjacencyMatrix){
        this.adjacencyMatrix = adjacencyMatrix;
        vertices = adjacencyMatrix.size();
    }

    public List<Bag<Integer>> getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(List<Bag<Integer>> adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

   Bag<Integer> getNeighbours(int vertex){
        if(vertex > adjacencyMatrix.size()){
            throw new RuntimeException(" vertex not found");
        }
        return adjacencyMatrix.get(vertex);
   }
}
