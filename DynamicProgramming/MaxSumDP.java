package DynamicProgramming;

public class MaxSumDP {

    public static void main(String args[]){

        int[] arr = {10,15,-30,10,-5,40,10};

        int[] max = new int[7];

        int start = 0;
        int end = 0;
        int maxx = Integer.MIN_VALUE;
        int curr = 0;
        for(int i =0; i < 7; i++){

            maxx = Math.max(maxx + arr[i], arr[i]);
            if(maxx == arr[i]){
                start = i;
                end = i;
            }else{
                end++;
            }


        }

        System.out.println(maxx + " " + start + " " + end);
    }
}
