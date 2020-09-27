package DSA;

public class BinarySearch {
    public static void main(String args[]){

        int[] a = {2,5,8,66,69,77,234,555,5678,23322};

        int searchTerm = 9;
        int alen = a.length;
        int lower = 0;
        int upper = alen-1;
        int mid = (lower+upper)/2;
        boolean found =false;

        while(mid >= 0 && mid < alen){

            if(a[mid] == searchTerm){
                found = true;
                System.out.println("term found at "+ mid);
                break;
            }else if(mid == lower || mid == upper){
                break;
            }
            else if( a[mid] > searchTerm){

               upper = mid;
               mid = (lower+upper)/2;

            }else if(a[mid] < searchTerm){
                lower = mid;
                mid = (upper+lower+1)/2;
            }
        }
        if(!found) {
            System.out.print("Not found");
        }


    }
}
