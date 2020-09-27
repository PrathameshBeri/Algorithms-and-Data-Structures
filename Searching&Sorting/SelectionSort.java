package DSA;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String args[]){


        int[] a = {3,546,65,2,5556732,4243547,24,34,83,19};

        int[] asorted = selectionSort(a);

        Arrays.stream(asorted).forEach(System.out::println);
    }

    static int[] selectionSort(int[] a){

        int smallest;
        int smallestpos;
        int len = a.length;
        for(int i = 0; i < a.length - 1; i++){
            smallest = a[i];
            smallestpos = i;
            for(int j = i+1; j< a.length; j++){

                if(a[j] < smallest){
                    smallest = a[j];
                    smallestpos = j;
                }

            }
            int temp = a[i];
            a[i] = smallest;
            a[smallestpos] = temp;
        }
        return a;
    }
}
