package DSA;

import java.util.Arrays;

public class MergeSort {

    public static void main(String args[]){


        int[] a = {3,546,65,2,5556732,4243547,24,34,83,19};

        sort(a, 0, a.length-1);

        Arrays.stream(a).forEach(System.out::println);

    }

     static void sort(int[] a, int start, int end){
      if(end - start >= 1){

          int middle = (start + end)/2;
          int middle2 = middle+1;

          sort(a, start, middle);
          sort(a, middle2, end);

          merge(a, start,middle,middle2, end);
      }
    }

    static void merge(int[] a, int start, int middle1, int middle2, int right) {

       int leftindex = start;
       int rightindex = middle2;
       int combinedindex= start;
       int[] combinedArray = new int[a.length];

       while(leftindex <= middle1 && rightindex <= right){

           if(a[leftindex] <= a[rightindex]){
               combinedArray[combinedindex++] =a[leftindex++];
           }else{
               combinedArray[combinedindex++] = a[rightindex++];
           }

       }

        if(leftindex == middle2){

            while(rightindex <= right){
                combinedArray[combinedindex++] = a[rightindex++];
            }

        }else{

            while(leftindex <= middle1){
                combinedArray[combinedindex++] = a[leftindex++];
            }
        }

        for(int i = start; i <= right; i++){
            a[i] = combinedArray[i];
        }
    }
}
