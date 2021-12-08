package Graphs.ADTs.RedBlackBST;

public class Node <T extends Comparable<? super T>>{


    private T value;
    private Node left;
    private Node right;
    private boolean color; //color of parent link, red is true, black is false.

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public Node(T value) {
        this.value = value;
    }
    public Node(T value, boolean val) {
        this.value = value;
        this.color = val;
    }

    public void setRight(T value){
        this.right = new Node(value);
    }

    public void setLeft(T value){
        this.left = new Node(value);
    }

    public Node(T value, Node left, Node right, boolean color) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.color = color;
    }


}
