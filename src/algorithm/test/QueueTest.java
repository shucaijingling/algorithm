package algorithm.test;

import algorithm.linear.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.enqueue("d");
        q.enqueue("e");

        for (String s : q) {
            System.out.println(s+"---");
        }

        String dequeue = q.dequeue();
        System.out.println(dequeue);
        String dequeue1 = q.dequeue();
        System.out.println(dequeue1);
        String dequeue2 = q.dequeue();
        System.out.println(dequeue2);
        String dequeue3 = q.dequeue();
        System.out.println(dequeue3);
        String dequeue4 = q.dequeue();
        System.out.println(dequeue4);


    }
}
