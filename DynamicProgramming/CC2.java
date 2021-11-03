package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CC2 {

        public static void main(String args[]) {
            int amount = 9;
            int[] coins = {1,2,5};

            int[] ways = new int[amount + 1];

            List<Integer> l = Arrays.stream(coins).boxed().collect(Collectors.toList());

            ways[0] = 1;
            for(int i = 1; i <= amount; i++){

                int wan = 0;
                int rem = i;
                int pair = 0;
                Set<Integer> set = new HashSet<>();
                for(int j = 0; j < coins.length; j++){

                    if(coins[j] > rem){
                        continue;
                    }else{

                        if(i == coins[j]){
                            wan++;
                            set.add(i);
                        }
                        else if(i % coins[j] == 0){
                            if(j == 0){
                                wan = ways[i -coins[j]];
                            }else{
                                wan++;
                            }
                            set.add(coins[j]);
                        }else{
                            int remainder = (i %coins[j]);
                            if( l.contains(remainder) && !set.contains(remainder)
                            || remainder % 2 == 0 && l.contains(2)){
                                wan++;
                                set.add(coins[j]);
                            }

                        }

                    }

                }

                ways[i] = wan;
            }


            for(int n : ways){
                System.out.print(" " + n);
            }

            System.out.println("\n" + ways[amount]);
        }


    }
