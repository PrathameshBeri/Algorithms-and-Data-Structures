package com.beri;


import java.util.Arrays;

public class InfixToPostFix {
    public static void main(String args[]){

        StringBuffer infix = new StringBuffer("(6+2)*5-8/4");
        StringBuffer postfixed = new StringBuffer();


        try {
           postfixed =  infixToPostFix(infix);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(postfixed.toString());

    }

    static StringBuffer infixToPostFix(StringBuffer ifs) throws Exception {
        Stack<Character> s = new Stack<>();
        StringBuffer pfs = new StringBuffer();

        s.push('(');
        ifs.append(')');
        int count = 0;

        while(!s.isEmpty()) {
            Character c = ifs.charAt(count);

            if((int)c > 48 && (int)c < 58){

                pfs.append(c);
            }
            else if(c == '('){
                s.push(c);
            }
            else if(isOperator(c)){

                char t = (char)s.peek();
                if(isOperator(t)){

                    while(isOperator((char)s.peek())){

                        int a1 = checkPrecedence(c);
                        int a2 = checkPrecedence((char)s.peek());

                        if(a1 == a2 || a2 > a1){
                            pfs.append(s.pop());
                        }else{
                            break;
                        }

                    }

                }
                s.push(c);

            }

            else if( c == ')'){

                while((char)s.peek() != '(' && isOperator((char)s.peek())){
                    pfs.append(s.pop());
                }

                if((char)s.peek() == '('){
                    s.pop();
                }
            }


            count++;
        }

        return pfs;

    }

    private static int checkPrecedence(Character c) throws Exception {
       switch (c){

           case '+':
           case '-':
               return 0;
           case '*':
           case '/':
           case '%':
               return 1;
           case '^':
               return 2;
           default:
               throw new IllegalArgumentException("Unknown character");
       }

    }

    static boolean isOperator(char c) {
        boolean isOp = false;

      char[] operators = {'+', '-', '*', '/', '^', '%'};

        for (int i = 0; i < operators.length; i++) {
            if(c == operators[i]){
                return true;
            }
        }

        return false;
    }



}
