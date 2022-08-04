package algorithm.linear;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T>{

    private T[] eles;//存储元素的数组
    private int N;//记录当前顺序表中的元素个数
    //创建容量为capacity的SequenceList对象
    public SequenceList(int capacity) {
        this.eles = (T[]) new Object[capacity];
        this.N = 0;
    }
    //控制线性表
    public void clear(){
        this.N=0;
    }
    //判断线性表是否为空，是返回true，否返回false
    public boolean isEmpty(){
        return N==0;
    }
    //返回线性表中元素的个数
    public int length(){
        return N;
    }

    //读取并返回线性表中的第i个元素的值
    public T get(int i){
        return eles[i];
    }

    //在线性表的第i个元素之前插入一个值为t的数据元素
    public void insert(int i,T t){

        if (N==eles.length){
            resize(2*eles.length);
        }

        for (int j = N-1; j >i; j--) {
            eles[j] = eles[j-1];
        }
        eles[i] = t;

    }

    //向线性表中添加一个元素
    public void insert(T t){
        if (N==eles.length){
            resize(2*eles.length);
        }
        eles[N++] = t;
    }

    //删除并返回线性表中第i个数据元素
    public T remove(int i) {
        if (N<eles.length/4){
            resize(eles.length/2);
        }
        T current = eles[i];
        for (int j = i + 1; j < N-1; j++) {
            eles[j-1] = eles[j];
        }
        N--;
        return current;
    }

    public void resize(int newSize){
        //定义一个临时数组 指向原数组
        T[] t = eles;

        //创建一个长度为newSize的新数组
        eles = (T[]) new Object[newSize];

    }

    //返回线性表中首次出现的指定的数据元素的位序号
    public int indexOf(T t){
        for (int i = 0; i < N - 1; i++) {
            if (eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    //遍历方法
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator{

        //指针
        private int cursor;

        //初始化为0；
        public SIterator(){
            this.cursor=0;
        }

        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public Object next() {
            return eles[cursor++];
        }
    }

}
