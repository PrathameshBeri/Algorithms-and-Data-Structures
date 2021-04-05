package ADTs.MST;

public interface Edge {

    int either();
    int other(int v);

    double getWeight();
    int compareTo(Edge that);



}
