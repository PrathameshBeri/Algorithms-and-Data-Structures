package ADTs;

import java.util.LinkedList;
import java.util.Scanner;

public class CircularPrison {

    public static void main(String args[]){


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter prisoners");
        int prisoners = sc.nextInt();
        System.out.println("Enter the starting prisonser");
        int start = sc.nextInt();
        CircularLinkedList cl = new CircularLinkedList();
        for(int i = 0; i < prisoners; i++){
            cl.addNode(i + 1);
        }

        Node current = cl.last;
        int count = 0;
        while(count < prisoners){

             current =  moveNext(current, start);
             current.executed = true;
              count++;
        }

         System.out.println(current.data);
    }

    private static Node moveNext(Node current, int count) {

        int cur = 0;
        while(cur < count){
            current = current.next;
            if(!current.executed){
                cur++;

            }
        }

         return current;
    }
}


class Node{
    int data;
    boolean executed;
    Node next;

    Node(int data){
        this.data = data;
        executed = false;
        next = null;
    }

}


class CircularLinkedList{
    Node start;
    Node last;

    public void addNode(int n){
        if(start == null && last == null){

            Node nod = new Node(n);
            start = last = nod;
            nod.next = start;
        }else{

            Node nod = new Node(n);
            last.next = nod;
            nod.next = start;
            last = nod;
        }
    }

    public void display(){
        Node star = start;
        while(star.next != start){
            System.out.println(star.data + " "  + star.executed);
            star = star.next;
        }

        System.out.println(star.data + " " + star.executed);

    }

}
