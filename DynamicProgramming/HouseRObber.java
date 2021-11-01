package DynamicProgramming;

class HouseRObber {
    public int rob(int[] nums) {


        int[] cost = new int[nums.length + 1];
        int[] houses = new int[nums.length + 1];
        for(int i =0; i < nums.length; i++){
            houses[i+1] = nums[i];
        }
        cost[0] = 0;
        cost[1] = nums[0];
        int min = 0;

        for(int i = 2; i < houses.length ; i++){
            int x = 0;
            int mina =(cost[i - 2] + houses[i ]);
            int i1 = cost[i - 1];

            if( mina > i1){
                x = mina;
            }else{
                x = i1;
            }
            cost[i] = x;

        }
        return cost[nums.length ];

    }
}