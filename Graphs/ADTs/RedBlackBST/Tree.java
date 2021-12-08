package Graphs.ADTs.RedBlackBST;

import Graphs.ADTs.RedBlackBST.Node;

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

    public int rank(T n){
        return searchHelper(root, n);

    }

    /*private Node searchHelper(Node n, T val){
        if(n == null){
            return null;
        }else if(n.getValue() == val){
            return n;
        }else if( n.getValue().compareTo(val) < 0){
            if(n.getRight() == null){
                return n;
            }else if(n.getRight().getValue().compareTo(val) < 0){
                return n;
            }else{
                return searchHelper(n.getRight(),val);
            }

        }else if(n.getValue().compareTo(val) > 0){

            if(n.getLeft() == null){
                return n;
            }else if(n.getLeft().getValue().compareTo(val) > 0){
                return searchHelper(n.getLeft(), val);
            }else{
                return n;
            }

        }

        return null;
    }
*/


    private int searchHelper(Node n, T val){
        if(n == null){
            return 0;
        }else if(n.getValue() == val){
            return rankHelper(n.getLeft());
        }else if( n.getValue().compareTo(val) < 0){
            if(n.getRight() == null){
                return  1 + rankHelper(n.getLeft());
            }else{
                return 1+ rankHelper(n.getLeft()) + searchHelper(n.getRight(), val);
            }

        }else if(n.getValue().compareTo(val) > 0){

            if(n.getLeft() == null){
                return 0;
            }else {
                return searchHelper(n.getLeft(), val);
            }

        }

        return 0;
    }
    private int rankHelper(Node n){
        if(n == null){
            return 0;
        }else if(n.getLeft() == null && n.getRight() == null){
            return 1;
        }else{

            return 1 + ( rankHelper(n.getLeft()) + rankHelper(n.getRight()));
        }

    }

}
