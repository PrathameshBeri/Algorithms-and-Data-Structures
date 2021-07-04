package Random;

public class XORTrick {
    public static void main(String args[]){

        int[] o = new int[]{4,3,4,5,6,2,9,10,11,12,13,14,15,16,17,18,19,20,1,7,9};
        int n = 0;

        for(int i = 1 ; i <21; i++){

            n ^= o[i];
        }

        for(int x : o){

            n ^= x;
        }
        System.out.println(" the duplicate number is " + n);
    }
}
