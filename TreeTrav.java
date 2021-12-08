import java.security.SecureRandom;

class TreeTrav{

    public static void main(String args[]){



        TreeStruct<Integer> tree1 = new TreeStruct<Integer>();

        SecureRandom random = new SecureRandom();

        System.out.printf("Inserting the following values %n");

        for(int i = 0; i < 10; i++){

            int value = random.nextInt(100);

            tree1.insertNode(value);

            System.out.printf("Inserting %d %n", value);
        }


        System.out.println("The inorder traversal of this tree is ");
        tree1.inOrderTraversal();

        tree1.inOrderTraversalMod(0);

    }


}