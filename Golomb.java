public class Golomb {

    public static void main(String[] args){

        //def golomb(n)
        //return 1 if n == 1
        //return 1 + golomb(n - golomb(golomb(n - 1)));
        //end
        System.out.println(calcGolomb(5));


    }

    static public int calcGolomb(int n){
        int[] nums = new int[n];
        for(int i = 0 ; i < n; i++){
            nums[i] = -1;
        }
        return golombHelper(n, nums);
    }

    private static int golombHelper(int n, int[] nums){

        if(n == 1){
            return 1;
        }else{

            if(nums[n -1] > 0){
                return nums[n -1];
            }else{
                int a = golombHelper(n -1, nums);
                if(nums[n -1] < 0 ) nums[n -1] = a;
                int b = golombHelper(a, nums);
                if(nums[n -1 ] < 0) nums[a] = b;
                return (1 + golombHelper(n -b, nums));
            }

        }

    }

}
