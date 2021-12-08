package DynamicProgramming;

public class KnapsackDpRepetition {

    public static void main(String args[]){

        int[] valMat = new int[11];

        for(int i = 0; i < 11; i++){
            valMat[i] = 0;
        }

        valMat[2] = 9;
        valMat[6] = 30;
        valMat[3] = 14;
        valMat[4] = 16;

        int weight = 10;

        int max[] = new int[weight + 1];

        for(int i = 0; i <= 10; i++){
            int mxx = Integer.MIN_VALUE;
            for(int j = 0; j <= i; j++){

                    mxx = Math.max(mxx, max[i - j] + valMat[j]);
            }
            max[i] = mxx;
        }

        System.out.println(max[10]);
    }
}
