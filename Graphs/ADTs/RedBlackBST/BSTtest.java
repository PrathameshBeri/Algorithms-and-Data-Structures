package Graphs.ADTs.RedBlackBST;

public class BSTtest {

    public static void main(String args[]){

        int[] arr = new int[]{25,15,50,10,22,35,70,4,12,18,24,31,44,66,90};

        int[] llrbarr1 = new int[]{};

        char[] llbss = new char[]{'s','e','a','r','c', 'h','x', 'm'};

        char[] llbss1 = new char[]{'t','v','f','b','d','z', 'n','g','i'};

     RedBlackTree<Character> rbt = new RedBlackTree<>();

        for(char c : llbss){
            rbt.insert(c);
        }

        //rbt.printInorder();

        System.out.println(rbt.root.isColor());
        for(char c : llbss){
            System.out.println(" the rank of char " + c + " is " + rbt.rank(c));
        }

    }
}
