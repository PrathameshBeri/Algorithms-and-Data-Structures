package DynamicProgramming;

public class RodCutting {
    public static void main(String args[]){

        int[] lengths = {1,2,3,4,5,6,7,8,9,10};
        int[] values = {1,5,8,9,10,17,17,20,24,30};

        int[] maxs = new int[lengths.length + 1];
        maxs[0] = 0;

        for(int i = 1; i <= lengths.length; i++){
            int max = Integer.MIN_VALUE;

            for(int j = 0; j < i; j++){
                max = Math.max(max, values[j] + maxs[i - j - 1] );
            }
            maxs[i] = max;
        }

        for(int i : maxs){
            System.out.println(i);
        }
    }
}
