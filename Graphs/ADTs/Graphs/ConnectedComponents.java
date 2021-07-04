package ADTs.Graphs;

public class ConnectedComponents {

    boolean[] marked;
    int[] connectedGroup;
    GraphStructure graph;
    BreadthFirstSearchHelper bfsHelper;

    ConnectedComponents(GraphStructure graph) {
        this.graph = graph;
        int vertices = graph.vertices;
        marked = new boolean[vertices];
        connectedGroup = new int[vertices];
        bfsHelper = new BreadthFirstSearchHelper(graph);
    }

    public void computeCC(){
        int count = 0;
        for(int i = 0; i < graph.vertices; i++){

            if(!marked[i]){

                bfsHelper.breadthFirstSearch(i);
                for(int j = 0 ; j < bfsHelper.vertices; j++ ){
                    if(bfsHelper.visited[j]){
                        marked[j] = true;
                        connectedGroup[j] = count;
                    }
                }
                bfsHelper.clearBFSResults();
                count++;
            }

        }


    }

}
