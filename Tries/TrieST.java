package Tries;

public class TrieST<T> {

    private static final int R = 256;
    Node root;

    public TrieST(){

    }

    public void put(String key, T value){
        root = putHelper(key, value, root, 0);
    }


    private Node putHelper(String key, T value, Node node, int digit){
        if(node == null) node = new Node();
        if(digit == key.length() - 1) {node.value = value; return node;}
        char c = key.charAt(digit);
        node.nodes[c] = putHelper(key, value, node.nodes[c], digit+1 );
        return node;
    }

    public boolean contains(String key){
        return get(key) != null;
    }

    public T get(String key){
        Node n = get(key, root, 0);
        if(n == null ) return null;
        return (T) n.value;
    }


    private Node get(String key, Node node, int digit){
        if(node == null ) return null;
        if(digit == key.length() - 1 ) return node;

        return get(key, node.nodes[key.charAt(digit)], digit+1);
    }

    private static class Node{

        Object value;
        Node[] nodes = new Node[R];

    }
}
