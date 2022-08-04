package algorithm.linear;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    private Node head;
    private int N;


    private class Node{
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Stack() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    //弹栈
    public T pop() {
        Node oldNode = head.next;
        if (oldNode == null){
            return null;
        }
        head.next = oldNode.next;
        N--;
        return oldNode.item;

    }

    //压栈
    public void push(T t) {
        Node newNode = new Node(t, null);
        newNode.next = head.next;
        head.next = newNode;
        N++;
    }


    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private Node n;

        public SIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

}
