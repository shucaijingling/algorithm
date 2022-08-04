package algorithm;

import java.util.PriorityQueue;

public class _K {


    public final PriorityQueue<Integer> queue;

    public final int k;


    public _K(int k,int[] arr) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int i : arr) {
            add(i);
        }
    }

    private int add(int i) {
        if (queue.size() < k){
            queue.offer(i);

        }else if (queue.peek() < i){
            queue.poll();
            queue.offer(i);
        }

        return queue.peek();
    }
}
