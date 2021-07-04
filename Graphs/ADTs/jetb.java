package ADTs;

import java.util.*;
import java.lang.*;

public class jetb {
    public static void main(String[] args) {
        // write your code here

        Scanner s = new Scanner(System.in);
       // System.out.println(" enter strings ");
        String k = s.nextLine();

        int bum = s.nextInt();
        String[] nums = k.split(" ");



        int[] inums = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            inums[i] = Integer.parseInt(nums[i]);
        }

        Arrays.sort(inums);

        int diff = Integer.MAX_VALUE;
        List<Integer> l = new ArrayList<>();

        for(int i = 0; i < inums.length; i++ ){

            int cdiff = Math.abs(inums[i] - bum);
            if(cdiff < diff){
                l = new ArrayList<>();
                l.add(inums[i]);
                diff = cdiff;
            }else if(cdiff == diff){
                l.add(inums[i]);
            }
        }

        for(int nk : l){
            System.out.print(nk + " ");
        }

    }
}
