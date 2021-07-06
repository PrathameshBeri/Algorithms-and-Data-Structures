package Graphs.ADTs.RedBlackBST;

public class RedBlackTree<T extends Comparable<? super T>> extends Tree<T>{



    @Override
    void insert(T data){

        if(root == null){
            this.root = new Node(data, null, null, false);

        }else{

           this.root= insertHelperLLRB(root, data);
        }
    }

    private Node<T> insertHelperLLRB(Node<T> node, T data) {

        if(node.getValue().compareTo(data) <= 0){
            if(node.getRight() == null){
                node.setRight(new Node(data,true));
                if(node.getLeft() != null && node.getLeft().isColor()){
                   node = flipColors(node);
                }else
                  node =  rotateLeft(node);
            }else{
                node.setRight(insertHelperLLRB(node.getRight(), data));

            }
        }else if(node.getValue().compareTo(data) >= 0){

            if(node.getLeft() == null){
                node.setLeft(new Node(data, true));

            }else{
                node.setLeft(insertHelperLLRB(node.getLeft(), data));
                if(node.isColor() && node.getLeft() != null && node.getLeft().isColor()){
                   node = rotateRight(node);
                    if(node.getLeft()!= null && node.getLeft().isColor() && node.getRight()!= null &&  node.getRight().isColor()){
                   node = flipColors(node);
                    }
                }
            }

        }
        return node;
    }

    public Node<T> rotateLeft(Node<T> node){
        Node x = node.getRight();
        node.setRight(x.getLeft());
        x.setLeft(node);
        x.setColor(node.isColor());
        node.setColor(true);
        return x;
    }

    public Node<T> rotateRight(Node<T> node){
        Node x = node.getLeft();
        node.setLeft(x.getRight());
        x.setRight(node);
        x.setColor(node.isColor());
        node.setColor(true);
        return x;
    }

    public Node flipColors(Node<T> node){
        node.setColor(true);
        node.getLeft().setColor(false);
        node.getRight().setColor(false);
        return node;
    }

}
