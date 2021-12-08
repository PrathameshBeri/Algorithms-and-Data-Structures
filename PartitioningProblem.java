package DynamicProgramming;

public class PartitioningProblem {

    public static void main(String args[]){



        int[] input = {1,1,1,1,1,1,1,1,1};

        int k = 3;

        int[][] m = new int[input.length + 1][k + 1];
        int[][] d = new int[input.length + 1][k + 1];
        int p[] = new int[input.length + 1];

        p[0] = 0;
        for(int i = 1; i <= input.length -1; i++){
            p[i] = p[i - 1] + input[i];
        }

        for(int i = 1; i <=  input.length; i++){
            m[i][0] = p[i];
        }
        for(int i = 0; i <= k ; i++){
            m[1][i] = input[0];
        }

        for(int i = 1; i <= input.length; i++){
            for(int j = 1; j <=k; j++ ){

                int max = Integer.MAX_VALUE;

                for(int o = 1; o < i -1; o++ ){
                    int val = Math.max(p[i] - p[o], m[o][j-1]);
                    if(max > val){
                        max = val;
                        m[i][j] = max;
                        d[i][j] = o;
                    }
                }
            }
        }

    reconstructPartition(input, m , input.length, k);
    }

    private static void reconstructPartition(int[] input, int[][] m, int l, int k) {
        if(k == 1){
            print(input, 1, input.length);
        }else{
            reconstructPartition(input, m, m[l][k], k -1);
            print(input, m[l][k] + 1, l);
        }
    }

    private static void print(int s[], int st, int end){
        for(int y = st; y < end; y++){
            System.out.print(s[y] + "  ");
        }
        System.out.println("--------");
    }
}
