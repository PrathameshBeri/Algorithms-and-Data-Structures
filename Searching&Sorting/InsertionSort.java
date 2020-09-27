package DSA;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String args[]){

        int[] a = {3,546,65,2,5556732,4243547,24,34,83,19};

        int[] asorted = insertionSort(a);
        Arrays.stream(asorted).forEach(System.out::println);
    }

    private static int[] insertionSort(int[] a) {

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j< a.length-1; j++){
                if(a[j+1] < a[j]){

                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }
}
