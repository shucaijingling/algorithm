package algorithm.linear;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T>{
    //记录首节点
    private Node head;
    //记录链表的长度
    private int N;



    //节点类
    private class Node{

        T item;
        Node next;

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    //构造方法，创建LinkList对象
    public LinkList(){

        this.head = new Node(null,null);
        this.N = 0;
    }

    //空置线性表
    public void clear(){

        head.next = null;
        this.N = 0;
    }

    //判断线性表是否为空，是返回true，否返回false
    public boolean isEmpty(){
        return N == 0;
    }

    //获取线性表中元素的个数
    public int length(){

        return N;
    }

    //获取并返回线性表中的第i个元素的值
    public T get(int i){
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }

    //往线性表中添加一个元素
    public void insert(T t){
        Node n = head;
        while (n.next != null){
            n = n.next;
        }
        n.next = new Node(t,null);
        N++;
    }

    //在线性表的第i个元素之前插入一个值为t的数据元素
    public void insert(int i,T t) {
        //找到i-1，断开连接，创建新节点，i-1指向新节点，新节点指向i节点
        Node pre = head;
        for (int index = 0; index <= i-1; index++) {
            pre = pre.next;
        }
        Node curr = pre.next;
        Node newNode = new Node(t,curr);
        pre.next = newNode;
        N++;

    }

    //删除并返回线性表中第i个数据元素
    public T remove(int i){
        Node pre = head;
        for (int index = 0; index < i-1; index++) {
            pre = pre.next;
        }
        Node curr = pre.next;
        pre.next = curr.next;
        N--;
        return curr.item;
    }

    //返回线性表中首次出现的指定的数据元素的位序号，若不存在，则返回-1
    public int indexOf(T t){
        Node n = head;

        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }
    //反转
    public void reverse(){
        if (isEmpty()){
            return;
        }
        reverse(head.next);
    }

    public Node reverse(Node curr){
        if (curr.next == null){
            //出口，遍历到最后一个需要把头结点指向逆序后的第一个，即为curr
            head.next = curr;
            return curr;
        }
        Node pre = reverse(curr.next);
        pre.next = curr;
        curr.next = null;
        return curr;

    }

    @Override
    public Iterator<T> iterator() {
        return new LIteraror();
    }

    private class LIteraror implements Iterator{

        private Node n;
        public LIteraror(){
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
