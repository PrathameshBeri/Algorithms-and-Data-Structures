package ADTs;

import java.util.Arrays;
import java.util.Comparator;

public class MaxNumber {

    public static void main(String args[]) {


        int[] arr = new int[]{10, 7, 76, 415};

        String[] s = Arrays.stream(arr).mapToObj(x -> String.valueOf(x)).sorted(
                (s1, s2) -> {
                    if (s1.charAt(0) > s2.charAt(0))
                        return -1;
                    else if (s1.charAt(0) < s2.charAt(0))
                        return 1;
                    else if (s1.charAt(0) == s2.charAt(0)) {
                        return Integer.parseInt(s2 + s1) - Integer.parseInt(s1 + s2);
                    } else return 0;
                }
        ).toArray(String[]::new);

        String h = String.join("", s);

        System.out.println(Integer.parseInt(h));
    }
}
