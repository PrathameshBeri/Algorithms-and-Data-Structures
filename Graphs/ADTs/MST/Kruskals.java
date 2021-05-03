package ADTs.MST;

import java.util.*;

public class Kruskals {

    Queue<Edge> mst = new LinkedList<>();

    Kruskals(EdgeWeightedGraph e){
        Queue<Edge> edgeQueue  = new PriorityQueue<>();
        for (Iterator<Edge> it = e.getEdges(0); it.hasNext(); ) {

            edgeQueue.add(it.next());
            Edge edge = it.next();
        }

         while(!edgeQueue.isEmpty() && mst.size() < e.getVertices() - 1){

             Edge eq = edgeQueue.poll();
             int e1 = eq.either(); int e2 = eq.other(e1);
             if(e1 != e2){
                 mst.add(eq);
             }
         }

    }


    public Iterable getMST(){
        return this.mst;
    }

}
