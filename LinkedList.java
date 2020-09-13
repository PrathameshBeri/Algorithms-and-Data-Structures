package com.beri;

import java.util.Arrays;

public class LinkedList {

    public static void main(String args[]){


        List<Integer> list = new List<>();

        Integer[] ints = {6,4, 7,3435, 65, 99, 22};

        Arrays.stream(ints).forEach(list::addFromFront);

        list.printList();

        System.out.println("Adding 69");
        list.addFromBack(69);

        list.printList();

        System.out.println("Removing from front");
        list.removeFromFront();

        list.printList();
    }
}
