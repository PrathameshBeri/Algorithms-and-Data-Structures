package ADTs.Graphs;

import java.util.Iterator;

public class Queue<T> {

    Node<T> head;
    Node<T> tail;

    class Node<T> {

        T data;
        Node next;

        Node(T item) {
            data = item;
            next = null;
        }

    }

    Queue(){
        head = tail = null;
    }
    Queue(T n) {

        Node newNode = new Node(n);
        head = tail = newNode;
    }

    /**
     * @returns Adds a Node to the back of the queue in FIFO manner.
     */
    void enqueue(T data) {
        if(this.isEmpty()){
            Node newNode = new Node(data);
            head = tail = newNode;
        }else {
            Node n = new Node(data);
            tail.next = n;
            tail = n;
        }
    }

    /**
     * Remove the head from the queue.
     * @return <T> data
     */
    T dequeue() {
        Node<T> removeNode = head;
        head = head.next;
        return removeNode.data;
    }

    boolean isEmpty() {
        return head == null;
    }

    Iterator<T> getIterator() {
        return new QueueIterator(head);
    }

    class QueueIterator implements Iterator<T> {
        Node<T> startNode;

        QueueIterator(Node n) {
            startNode = n;
        }

        @Override
        public boolean hasNext() {
            return startNode != null;
        }

        @Override
        public T next() {
            T data = startNode.data;
            startNode = startNode.next;
            return data;
        }
    }
}
