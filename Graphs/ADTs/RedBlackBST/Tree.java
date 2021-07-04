package ADTs.RedBlackBST;

public class Tree<T extends Comparable<? super T>> {

    Node<T> root;

    Tree(){
        this.root = null;
    }
    Tree(T data){

        this.root = new Node(data);

    }

    void insert(T data){

        if(root == null){
            this.root = new Node(data);

        }else{

            insertHelper(root, data);
        }
    }

    private void insertHelper(Node<T> node, T data) {

        if(node.getValue().compareTo(data) <= 0){
            if(node.getRight() == null){
                    node.setRight(data);
            }else{
                insertHelper(node.getRight(), data);
            }
        }else if(node.getValue().compareTo(data) >= 0){

            if(node.getLeft() == null){
                node.setLeft(data);
            }else{
                insertHelper(node.getLeft(), data);
            }

        }

    }

    public void printInorder(){
        inorderHelper(this.root);
    }

    private void inorderHelper(Node<T> root) {
        if(root == null){
            return;
        }else{
            inorderHelper(root.getLeft());
            System.out.print(" " + root.getValue() + " ");
            inorderHelper(root.getRight());

        }

    }

}
