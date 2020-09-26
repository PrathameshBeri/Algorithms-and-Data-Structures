package Recursion;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NQueens {
    public static void main(String args[]){


        int[][] board = new int[8][8];

        System.out.println("Enter the position of the queen");

        Scanner scan = new Scanner(System.in);

        String pos = scan.nextLine();

        int[] posn =  Arrays.stream(pos.split(" ")).mapToInt(x -> Integer.valueOf(x)).toArray();

        System.out.println("The positions are " + posn[0] + " " + posn[1]);

        List<String> strings = getAttackPositions(posn[0], posn[1]);
    }

    static List<String> getAttackPositions(int x, int y){


        return null;
    }
}
