package algorithm.test;

import algorithm.priority.IndexMinPriorityQueue;

public class IndexMinPriorityQueueTest {
    public static void main(String[] args) {
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<>(10);
        queue.insert(0,"A");
        queue.insert(1,"C");
        queue.insert(2,"N");
        queue.insert(3,"G");
        queue.insert(4,"Z");
        queue.insert(5,"X");

        queue.changeItem(2,"B");

        /*while (!queue.isEmpty()){
            int index = queue.delMin();
            System.out.println(index+" ");
        }*/

        while (!queue.isEmpty()){
            int i = queue.delMin();
            System.out.println(i+" ");
        }

    }
}
