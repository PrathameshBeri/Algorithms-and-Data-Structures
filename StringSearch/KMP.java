package StringSearch;

public class KMP {

    int R = 256;

    String pat;

    KMP(String pattern){
        pat = pattern;

        int M = pat.length();

        int[][] dfa = new int[R][M];

        dfa[pat.charAt(0)][0] = 1;

        for(int X = 0, j = 1; j < M; j++){

            for(int i = 0; i < R; i++){
                dfa[i][j] = dfa[i][X];
            }
            dfa[pat.charAt(j)][j] = j + 1;
            X = dfa[pat.charAt(j)][X];
        }

    }


}
