package ADTs.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BreadthFirstSearch {

    public static void main(String args[]) throws IOException {


        GraphStructure graph;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of vertices");
        int vertices = Integer.parseInt(br.readLine());
        System.out.println("Enter the number of edges");
        int edges = Integer.parseInt(br.readLine());
        graph = new GraphStructure(vertices);
        System.out.println("Enter the vertices");
        for (int i = 0; i < edges; i++) {
            Integer[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).boxed().toArray(Integer[]::new);
            graph.addEdge(edge[0], edge[1]);

        }

        BreadthFirstSearchHelper bfs = new BreadthFirstSearchHelper(graph);
        bfs.breadthFirstSearch(0);
        Arrays.stream(bfs.edgeTo).forEach(System.out::println);

    }
}
