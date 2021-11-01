package DynamicProgramming;

public class LongestCommonSubsequence {
    public static void main(String args[]){


        String a = "ggcaccacg";
        String b = "acggcggatacg";

       // a = a.substring(6,9);
      //  b = b.substring(7,12);

        int y = a.length();
        int z = b.length();



      //  System.out.println(y + " " + z);

        int[][] mat = new int[y + 1][z + 1];
        for(int i = 0; i < z; i++){
            mat[0][i] = 0;
        }
        for(int i = 0; i < y; i++){
            mat[i][0] = 0;
        }
        StringBuffer o = new StringBuffer();
        for(int i = 1; i < y +1; i++){
            for(int j = 1; j < z + 1; j++){

                if(a.charAt(i - 1) == b.charAt(j - 1)){
                    mat[i][j] = mat[i-1][j-1] + 1;

                }else {
                    mat[i][j] = Math.max(mat[i][j-1], mat[i -1][j]);
                }
            }


        }

        int m = 0;
        for(int i = 1; i < y +1; i++) {
            for (int j = 1; j < z +1; j++) {

               if(mat[i][j] > m){
                   o.append(a.charAt(i - 1));
                   m = m+1;
                   break;
               }
            }

        }

        System.out.println(mat[y][z]);
       System.out.println(o.toString());
    }
}
