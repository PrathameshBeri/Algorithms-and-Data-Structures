package com.beri;

public class Stack<T> {

    private List<T> stack;

    Stack(){

        stack = new List<>();
    }
    Stack(T data){

        stack = new List(data);

    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }


    public void push(T data){

        stack.addFromFront(data);
    }

    public T pop(){

        if(stack.isEmpty()){
            return null;
        }

        T data = stack.removeFromFront();
        return data;
    }

    public void printStack(){
        this.stack.printList();
    }

    public T peek(){
        return stack.firstNode.getData();
    }

}
