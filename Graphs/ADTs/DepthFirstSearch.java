package ADTs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DepthFirstSearch {

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

        //   graph.printGraphStructure();

        DepthFirstSearchHelper dfs = new DepthFirstSearchHelper(graph);
        dfs.depthFirstSearch(6);
        Arrays.stream(dfs.edgeTo).forEach(System.out::println);

    }
}
