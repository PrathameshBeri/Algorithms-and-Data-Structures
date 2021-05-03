package ADTs;

import java.util.Iterator;

public class BagTest {
    public static void main(String args[]){

        Bag<Integer> bag1 = new Bag<>();
        Bag<String> bag2 = new Bag<>();

        bag1.addItem(4);
        bag1.addItem(5);
        bag2.addItem("siz");
        bag2.addItem("terp");
        Iterator<String> s = bag2.getAll();

        while(s.hasNext()){
            String g = s.next();
            System.out.println(g);
        }
    }
}
