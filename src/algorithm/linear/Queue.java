package algorithm.linear;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{
    //队列头节点
    private Node head;
    //队列长度
    private int N;
    //队列尾节点
    private Node last;



    //节点类
    private class Node {
        T item;
        Node next;

        //节点构造
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    public Queue(){
        this.head = new Node(null,null);
        this.last = null;
        this.N = 0;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //队列长度
    public int size() {
        return N;
    }

    //从队列中拿出一个元素
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        Node first = head.next;
        head.next = first.next;
        N--;
        if (isEmpty()) {
            last = null;
        }
        return first.item;

    }

    //队列中插入一个元素
    public void enqueue(T t) {
        if (last == null) {
            last = new Node(t, null);
            head.next = last;
        }else {
            //从尾部插入
            Node oldLast = last;
            last = new Node(t, null);
            oldLast.next = last;
        }
        N++;
    }


    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator{

        private Node n;

        public QIterator(){
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}
