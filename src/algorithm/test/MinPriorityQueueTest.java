package algorithm.test;

import algorithm.priority.MaxPriorityQueue;
import algorithm.priority.MinPriorityQueue;

public class MinPriorityQueueTest {
    public static void main(String[] args) {
        MinPriorityQueue<String> queue = new MinPriorityQueue<>(10);

        queue.insert("G");
        queue.insert("F");
        queue.insert("E");
        queue.insert("D");
        queue.insert("C");
        queue.insert("B");
        queue.insert("A");

        while (!queue.isEmpty()){
            String delmin = queue.delMin();
            System.out.print(delmin +" ");
        }
    }
}
