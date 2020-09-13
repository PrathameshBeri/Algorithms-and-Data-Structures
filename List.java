package com.beri;

public class List<T> {

    ListNode<T> firstNode;
    ListNode<T> lastNode;

    public List(){

        firstNode = lastNode = null;
    }

    public List(T node){

        this.firstNode = this.lastNode = new ListNode<>(node);

    }

    public boolean isEmpty(){

        if(firstNode == null) {
            return true;
        }else{
            return false;
        }

    }

    public void addFromFront(T node){
        ListNode n = new ListNode(node);
        if(this.isEmpty()){
            firstNode = lastNode = n;
        }else{

            n.setNextNode(firstNode);
            firstNode = n;
        }

    }

    public void addFromBack(T node){
        ListNode n = new ListNode(node);
        if(this.isEmpty()){
            throw new NullPointerException();
        }else{
            lastNode.setNextNode(n);
            lastNode = n;
        }

    }

    public T removeFromFront(){
        if(this.isEmpty()){
            throw new NullPointerException();
        }else{
            T data = firstNode.getData();
            firstNode = firstNode.getNextNode();
            return data;
        }

    }

    public void removeFromBack(){
        if(this.isEmpty()){
            throw new NullPointerException();
        }else{

            ListNode node = firstNode;

            while(node.getNextNode() != lastNode){
                node = node.getNextNode();
            }

            lastNode = node;

        }

    }

    public void printList(){
        if(this.isEmpty()){
            throw new NullPointerException();
        }else {
            ListNode n = firstNode;
            while(n != null) {
                System.out.print(n.getData() + " ");
                n = n.getNextNode();

            }
            System.out.println();

        }
    }


}
