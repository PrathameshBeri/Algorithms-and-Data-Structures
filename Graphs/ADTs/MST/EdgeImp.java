package ADTs.MST;

public class EdgeImp implements Edge{

    private double weight;
    private int v, w;

    public EdgeImp(double weight, int v, int w) {
        this.weight = weight;
        this.v = v;
        this.w = w;
    }

    @Override
    public int either() {
        return v;
    }

    @Override
    public int other(int v) {
        return (this.v == v) ? w : v;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Edge that) {
        return (int)(weight - that.getWeight());
    }


}
