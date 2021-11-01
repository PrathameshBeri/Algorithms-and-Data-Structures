package DynamicProgramming;

public class InstallRouters {
    public static void main(String args[]){


        int[] houses = {0,1,4,12,8,13,11};

        int[] cost = new int[houses.length + 1];
        cost[0] = 0;
        cost[1] = houses[0];
        int min = 0;
        for(int i = 2; i < houses.length - 1; i++){
        int x = 0;
        int mina =(cost[i - 2] + houses[i ]);
            int i1 = cost[i - 1] + houses[i + 1];

            if( mina < i1){
                x += mina;
            }else{
                x = i1;
            }
            cost[i] = x;

        }

        for(int i : cost){
            System.out.print(" " + i);
        }
    }
}
