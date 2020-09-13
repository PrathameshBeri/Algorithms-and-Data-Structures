package com.beri;

public class PalindromeTester {
    public static void main(String args[]){


        Stack<Character> st = new Stack<>();
        Stack<Character> st1 = new Stack<>();

        String y = " abba&$#^ j  ";

        for(int i = 0; i < y.length(); i++) {

            char t = y.charAt(i);
            if (y.charAt(i) < 'a' || y.charAt(i) > 'z') {

            } else {
                st.push(new Character(t));
            }
        }

        StringBuffer k = new StringBuffer();
        StringBuffer k1 = new StringBuffer();
        while(!st.isEmpty()){
            char c = st.pop();
            k.append(c);
            st1.push(c);
        }

        System.out.println(st1.peek());

        while(!st1.isEmpty()){

            char c1 = st1.pop();
            k1.append(c1);
        }

        if(k.toString().equals(k1.toString())){

            System.out.println("It is a palindrome");

        }else{
            System.out.println("Not a palindrome ");
        }


    }
}
