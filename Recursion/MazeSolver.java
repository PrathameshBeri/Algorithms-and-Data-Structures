package DSA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MazeSolver {
    public static void main(String args[])
    {


        String m = "#############...#......#..#.#.####.####.#....#.##....###.#.#####.#.#.#.##..#.#.#.#.###.#.#.#.#.##........#.#######.###.##......#...#########.###";
         String m1 = "#############...#......#..#.#.####.####.#....#.##....###.#..####.#.#.#.##..#.#.#.#.###.#.#.#.#.##........#.#######.###.##......#...#############";
        char[][] maze = new char[12][12];
        int n = 0;
        int loop = 0;
        while(loop < 12){

            String chunk = m1.substring(n, n+12);
            char[] c = chunk.toCharArray();
            maze[loop] = c;
            loop++;
            n+=12;
        }

        List<int[]> paths = new ArrayList<>();
        paths.add(new int[]{2,0});
        List<int[]> path = mazesolver(0,maze,paths);

        for(int[] step : path){
            int x = step[0];
            int y = step[1];
            maze[x][y] = 'X';
        }

        printMaze(maze);
    }

    static List<int[]> mazesolver(int position, char[][] maze, List<int[]> path) {

        //check the available positions from position
        //if aval, add to path, move
        //if need to backtrack, go back to prev posiiton in list and check and work back.
        //if new postion found, remove the entries proceeding the current entry.
        int[] posns = path.get(position);
        int x = posns[0];
        int y = posns[1];
        boolean solnf = false;
        if (x == 11 || y == 11) {
            solnf = true;
            return path;
        } else {
            boolean dir = false;

            if (x - 1 >= 0 && !solnf) {
                if (maze[x - 1][y] != '#' && maze[x-1][y] != 'O' && !solnContainsPostion(path, x - 1, y)) {
                    dir = true;

                    removeExcess(path, position, maze);
                    path.add(new int[]{x - 1, y});
                    return mazesolver(position + 1, maze, path);
                }
            }
            if (x + 1 < 12 && !solnf) {
                if (maze[x + 1][y] != '#' && maze[x+1][y] != 'O' && !solnContainsPostion(path, x + 1, y)) {
                    dir = true;

                    removeExcess(path, position, maze);
                    path.add(new int[]{x + 1, y});
                    if (x + 1 == 11) {
                        System.out.println("Path found");

                    }
                    return mazesolver(position + 1, maze, path);


                }

            }
            if (y + 1 < 12 && !solnf ) {
                if (maze[x][y + 1] != '#' && maze[x][y + 1] != 'O' && !solnContainsPostion(path, x, y + 1)) {
                    dir = true;

                    removeExcess(path, position, maze);
                    path.add(new int[]{x, y + 1});
                    if (y + 1 == 11) {
                        System.out.println("Path found");
                    }
                    return mazesolver(position + 1, maze, path);

                }
            }
            if (y - 1 > 0 && !solnf ) {
                if (maze[x][y - 1] != '#' && maze[x][y - 1] != 'O' && !solnContainsPostion(path, x, y - 1)) {
                    dir = true;

                    removeExcess(path, position, maze);
                    path.add(new int[]{x, y - 1});
                    return mazesolver(position + 1, maze, path);


                }
            }

            if (!dir) {
                return mazesolver(position - 1, maze, path);
            }

            return new ArrayList<int[]>();

        }
    }
    static boolean solnContainsPostion(List<int[]> lis, int x, int y){

        return lis.stream().filter(a -> a[0] == x && a[1] ==y).findFirst().isPresent();
    }

    static void removeExcess(List<int[]> path, int position, char[][] maze){
       int size = path.size();
       if(size-1 > position) {
           int[] block = path.get(position+1);
           int xb = block[0];
           int yb = block[1];
           maze[xb][yb] = 'O';
//           Iterator it = path.iterator();
//           int count = 0;
//           while (it.hasNext()) {
//               if (count > position) {
//                   it.remove();
//               } else {
//                   it.next();
//                   count++;
//               }
//           }
          while(path.size()-1 > position){
              path.remove(position+1);
          }

       }

    }

    static void printMaze(char[][] maze){
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
