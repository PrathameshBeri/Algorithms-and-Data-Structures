package DynamicProgramming;

public class PascalTriangle {
    public static void main(String[] args){


        final int levels = 6;

        int[][] triangle = new int[levels][levels];

        for(int i = 0; i < levels; i++) {
            for(int j = 0; j <= i; j++ ){

                triangle[i][j] = 1;
            }

        }


        for(int i = 1; i < levels; i++){
            for(int j = 1; j<= i; j++){
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }


        for(int i = 0; i < levels; i++){
            for(int j = 0 ; j <= i; j++){
                System.out.print(" " + triangle[i][j] + " ");
            }
            System.out.println();
        }
    }

}
