package ADTs;

import java.util.Stack;

public class AdtHanoi {

    public static void main(String args[]){

        Peg source = new Peg(1);
        Peg dest = new Peg(3);
        Peg helper = new Peg(2);

        for(int g = 3; g > 0; g--){

            source.push(new Ring(g));
        }

        adtHanoi(3, source, dest, helper);
    }

    
    public static void adtHanoi(int n, Peg source, Peg dest, Peg helper){
        if(n == 1){
            Ring s = source.pop();
            dest.push(s);
            System.out.println("Ring with weight " + s.num + " popped from peg " + source.num
             + " pushed to peg " + dest.num);
        }
        else{
            adtHanoi(n -1, source, helper, dest);
            Ring s = source.pop();
            dest.push(s);
            System.out.println("Ring with weight " + s.num + " popped from peg " + source.num
                    + " pushed to peg " + dest.num);
            adtHanoi(n-1, helper, dest, source);
        }
    }


}


class Ring{

    int num;

    Ring(int n){num = n;}

}

class Peg{

    Stack<Ring> s;
    int num;
    Peg(int num){
        this.num = num;
        s = new Stack<>();
    }

    int getNum(){
        return num;
    }

    Ring pop(){
        return s.pop();
    }

    void push(Ring r){
        s.push(r);
    }
}
