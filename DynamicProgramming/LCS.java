package DynamicProgramming;

public class LCS {
    public static void main(String args[]){

        int[] nums = {1,3,6,7,9,4,10,5,6};
        int[] arr = new int[nums.length + 1];

        arr[0] = 0;

        int sum = nums[0];
        int mx = 0;

        int[] mins = new int[nums.length + 1];
        mins[0] = Integer.MIN_VALUE;
        for(int i = 1; i <= nums.length; i++){
            int use = nums[i - 1];

            if(mins[i - 1] < nums[i -1]){
                mins[i] = nums[i - 1];
                arr[i] = arr[i -1] + 1;

            }else if( mins[i - 1] == nums[i - 1]){
                mins[i] = nums[i - 1];
                arr[i] = arr[i -1] ;
            }
            else{
                int close = i - 1;
                while(close >= 0){
                    if(mins[close] > nums[i - 1]){
                        close--;
                    }else{
                        break;
                    }
                }
//                if(((arr[close]  ) > arr[i-1])){
//                    mins[i] = nums[i-1];
//                    arr[i] = arr[close] + 1;
//
//                }else{
                    mins[i] = nums[i-1];
                    arr[i] = arr[i-1] ;


            }


        }

        for(int i = 0; i <= nums.length; i++){
            System.out.print(" " + arr[i]);
        }
        System.out.println();
        for(int i = 0; i <= nums.length; i++){
            System.out.print(" " + mins[i]);
        }
        System.out.println( arr[nums.length]);

    }
}
