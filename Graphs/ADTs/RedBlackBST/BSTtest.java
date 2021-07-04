package ADTs.RedBlackBST;

public class BSTtest {

    public static void main(String args[]){

        int[] arr = new int[]{25,15,50,10,22,35,70,4,12,18,24,31,44,66,90};

        int[] llrbarr1 = new int[]{};

        char[] llbss = new char[]{'s','e','a','r','c', 'h','x','m','p','l'};

     RedBlackTree<Character> rbt = new RedBlackTree<>();

        for(char c : llbss){
            rbt.insert(c);
        }

        rbt.printInorder();
        //System.out.println(rbt.root.isColor());
    }
}
