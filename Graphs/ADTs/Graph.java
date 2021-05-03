package ADTs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

public class Graph {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int edges;
        int vertices;
        edges = Integer.parseInt(br.readLine());
        vertices = Integer.parseInt(br.readLine());
        Bag<Integer>[] adjMat = new Bag[vertices];
        for(int i = 0; i < edges; i++){
            adjMat[i] = new Bag<>();
        }

        for(int i = 0; i < edges; i++){
            Integer[] edge =  Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).boxed().toArray(Integer[]::new);
                adjMat[edge[0]].addItem(edge[1]);
                adjMat[edge[1]].addItem(edge[0]);

        }
        int count = 0;
        for(Bag b : adjMat){
            System.out.print(count + " -> ");
            Iterator f = b.getAll();
            while(f.hasNext()){
                System.out.print(" " + f.next());
            }

            count++;
            System.out.println();
        }
    }
}


