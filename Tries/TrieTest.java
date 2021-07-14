package Tries;

public class TrieTest {
    public static void main(String args[]){


        TrieST<Integer> trie = new TrieST<>();

        String[] arr = new String[]{"she", "sells", "seas", "shells"};
        int j = 0;
        for(String i : arr){
            trie.put(i, j);
            j++;
        }

        System.out.println(trie.get("she"));
        System.out.println(trie.contains("shore"));
        System.out.println(trie.contains("sells"));

    }
}
