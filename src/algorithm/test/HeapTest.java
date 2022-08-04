package algorithm.test;

import algorithm.heap.Heap;

import java.util.HashMap;

public class HeapTest {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(10);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");

        String s = null;
        while ((s = heap.delMax()) != null) {
            System.out.print(s+" ");
        }
    }
}
