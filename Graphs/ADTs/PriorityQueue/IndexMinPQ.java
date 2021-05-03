package ADTs.PriorityQueue;

public interface IndexMinPQ <Item extends Comparable<Item>>{

   void insert(int k, Item N);
   void change(int k, Item N);
   boolean contains(int k);
   void delete(int k);
   Item min();
   int minIndex();
   int delMin();
   boolean isEmpty();
   int size();

}
