package ADTs.EdgeWeightedDigraph;

import ADTs.IndexMinPQ;

import java.util.Iterator;
import java.util.Stack;

public class DjikstraAlgorithm implements ShortestePathAPI{

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;


    @Override
    public void initialize(EdgeWeightedDigraph g, int vertex) {

        edgeTo = new DirectedEdge[g.getVertices()];
        distTo = new double[g.getVertices()];
        pq = new IndexMinPQ<>(g.getVertices());

        for(int i = 0; i < g.getVertices(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[vertex] = 0.0;
        pq.insert(vertex, 0.0);
        while(!pq.isEmpty()){

            int v = pq.delMin();
            for (Iterator<DirectedEdge> it = g.getEdges(v); it.hasNext(); ) {
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

            if(pq.contains(e.getTo())) pq.decreaseKey(e.getTo(), distTo[e.getTo()]);
            else
                pq.insert(e.getTo(), distTo[e.getTo()]);

        }
    }

    @Override
    public double distanceTo(int v) {
        return distTo[v];
    }

    @Override
    public Iterable<DirectedEdge> pathTo(int v) {
        Stack<DirectedEdge> s = new Stack<>();

        for(DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.getFrom()]){
            s.push(e);

        }
        return s;
    }
}
