package ADTs.EdgeWeightedDigraph;

public interface ShortestePathAPI {

    /**
            Calculate the shortest path in the given edge weighted digraph from the vertex to all
            other vertices
     */
    void initialize(EdgeWeightedDigraph g, int vertex);

    /**
            Return the distance from the initialization vertex to the specified vertex
     */
    double distanceTo(int v);


    /**
            Return the path from the initialisation vertex to the vertex specified
     */
    Iterable<DirectedEdge> pathTo(int v);


}
