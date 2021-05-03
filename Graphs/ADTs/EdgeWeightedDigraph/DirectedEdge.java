package ADTs.EdgeWeightedDigraph;

public class DirectedEdge {

    int v, u;

    double weight;

    public DirectedEdge(int v, int u, double weight) {
        this.v = v;
        this.u = u;
        this.weight = weight;
    }

    public int getFrom() {
        return v;
    }

    public int getTo() {
        return u;
    }

    public double getWeight() {
        return weight;
    }
}
