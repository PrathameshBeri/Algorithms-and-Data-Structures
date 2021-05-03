package ADTs.EdgeWeightedDigraph;

import ADTs.IndexMinPQ;

import java.util.Iterator;

public class EdgeWeightedDAG implements ShortestePathAPI {


    private DirectedEdge[] edgeTo;
    private double[] distTo;

    private int[] topoSorted;


    @Override
    public void initialize(EdgeWeightedDigraph g, int vertex) {
        edgeTo = new DirectedEdge[g.getVertices()];
        distTo = new double[g.getVertices()];

        for(int i = 0; i < g.getVertices(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[vertex] = 0.0;

        TopologicalSortEW ew = new TopologicalSortEW(g);
        ew.createTopologicalSort();
        for(int i : ew.getPostOrder()){

            for (Iterator<DirectedEdge> it = g.getEdges(i); it.hasNext(); ) {
                DirectedEdge e = it.next();
                relax(e);
            }

        }
    }

    private void relax(DirectedEdge e) {
        double w = distTo[e.getTo()];
        if( w  > distTo[e.getFrom()] + e.getWeight()){
            distTo[e.getTo()] = distTo[e.getFrom()] + e.getWeight();
            edgeTo[e.getTo()] = e;
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
