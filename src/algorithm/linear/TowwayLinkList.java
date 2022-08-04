package algorithm.linear;


import java.util.Iterator;

/**
 * 双向链表
 */
public class TowwayLinkList<T> implements Iterable<T>{
    private Node head;
    private Node last;
    private int N;



    private class Node{
        T item;
        Node pre;
        Node next;
        public Node(T item, Node pre, Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public TowwayLinkList(){
        this.head = new Node(null,null,last);
        this.last = null;
        this.N = 0;
    }
    public void clear(){
        this.head.next = null;
        this.last = null;
        this.N = 0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int length(){
        return N;
    }

    public T get(int i){
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n=n.next;
        }
        return n.item;
    }

    public void insert(T t){
        if (isEmpty()){
            Node newNode = new Node(t, head, null);
            last = newNode;
            head.next = last;
        }else {
            Node oldLast = last;
            last = new Node(t,oldLast,null);
            oldLast.next = last;
        }
        N++;
    }
    public void insert(int i ,T t){
        Node n = head;
        //遍历找出i-1节点
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        Node curr = n.next;
        Node newNode = new Node(t, n, curr);
        curr.pre = newNode;
        n.next = newNode;
        N++;

    }
    public T remove(int i){
        Node n = head;
        //i-1
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        Node curr = n.next;
        n.next = curr.next;
        curr.next.pre = n;
        N--;
        return curr.item;

    }
    public int indexOf(T t){
        Node n = head;
        for (int index = 0; n.next!=null; index++) {
            n = n.next;
            if (n.next.equals(t)){
                return index;
            }
        }
        return -1;
    }

    public T getFirst(){

        return isEmpty()?null:head.next.item;
    }

    public T getLast(){
        return isEmpty()?null:last.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }
    private class TIterator implements Iterator{

        private Node n;

        public TIterator(){
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
