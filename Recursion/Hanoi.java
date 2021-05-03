package ADTs;

public class Hanoi {

    public static void main(String args[]){

        hanoi(4,1,3,2);
    }


    public static void hanoi(int rings, int source, int dest, int helper){

        if(rings == 1){
            System.out.println("moving ring from source " + source + " to dest " + dest);
        }else{

            hanoi(rings - 1, source, helper, dest);
            System.out.println("Moving ring from source " + source + " to dest " + dest);
            hanoi(rings -1, helper, dest, source);
        }

    }
}
