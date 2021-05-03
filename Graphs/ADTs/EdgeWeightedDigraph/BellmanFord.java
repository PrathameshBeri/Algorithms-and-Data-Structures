package ADTs.EdgeWeightedDigraph;

public class BellmanFord implements ShortestePathAPI {

    private double[] distTo;
    private DirectedEdge[] edgeTo;

    @Override
    public void initialize(EdgeWeightedDigraph g, int vertex) {
        distTo = new double[g.getVertices()];
        edgeTo = new DirectedEdge[g.getVertices()];
        for (int i = 0; i < g.getVertices(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[vertex] = 0.0;

        for (int i = 0; i < g.getVertices(); i++) {
            for (int v = 0; v < g.getVertices(); v++) {

                for (DirectedEdge e : g.getIterableEdges(v)) {
                    relaxEdge(e);
                }
            }
        }
    }

    private void relaxEdge(DirectedEdge e) {
        int v = e.getFrom();
        int w = e.getTo();
        double cw = distTo[w];
        if (cw > distTo[v] + e.getWeight()) {
            distTo[w] = distTo[v] + e.getWeight();
            edgeTo[w] = e;
        }

    }


    @Override
    public double distanceTo(int v) {
        return 0;
    }

    @Override
    public Iterable<DirectedEdge> pathTo(int v) {
        return null;
    }
}
