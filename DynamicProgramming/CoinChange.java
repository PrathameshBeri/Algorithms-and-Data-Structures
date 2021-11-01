package DynamicProgramming;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        int[] change = new int[amount + 1];
        change[0] = 0;

        if(amount == 0 ) return 0;
        for(int i = 1; i < change.length; i++){

            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(coins[j] == i){
                    min = 1;
                    break;
                }
                else if(coins[j] > i){

                    continue;
                }else{

                    int x =change[i -coins[j]] ;
                    if(x > 0)
                        min = Math.min(min, x + 1 );

                }


            }
            if(min == Integer.MAX_VALUE || min == 0){min = -1;}
            change[i] = min;
        }
        for(int n : change){
            System.out.print(" " + n);
        }

        return change[amount];
    }
}