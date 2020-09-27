package DSA;

public class BinarySearchRecursive {
    public static void main(String args[]){

        int[] a = {2,5,8,66,69,77,234,555,5678,23322};
        int searchTerm = 233444;
        int alen = a.length;
        int lower = 0;
        int upper = alen;
        int loc = binarySearch(a,lower, upper, searchTerm);
        if(loc >= 0){
            System.out.println("Found at " + loc );
        }else{
            System.out.println("Not found");
        }

    }

    static int binarySearch(int[]a, int lower, int higher, int search) {

        int mid = (lower + higher) / 2;
        if (a[mid] == search) {
            return mid;
        } else if (mid == lower || mid == higher) {
            return -1;
        } else if (a[mid] > search) {
           return binarySearch(a, lower, mid-1, search);
        } else {
           return  binarySearch(a, mid+1, higher, search);
        }

    }
}
