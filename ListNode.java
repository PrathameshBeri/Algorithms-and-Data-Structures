package com.beri;

public class ListNode<T> {

    private T data;
    private ListNode nextNode;

    public ListNode(T data){
        this.data = data;
        this.nextNode = null;
    }

    public ListNode(T data, ListNode nextNode){
        this.data = data;
        this.nextNode = nextNode;
    }

    public T getData(){
        return this.data;
    }

    public ListNode getNextNode(){

        return nextNode;
    }

    public void setNextNode(ListNode node){

        this.nextNode = node;
    }

}
