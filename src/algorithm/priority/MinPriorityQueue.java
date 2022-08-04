package algorithm.priority;

/**
 * 最小优先队列
 * 实现最小堆，父节点小于子节点
 */
public class MinPriorityQueue<T extends Comparable<T>> {
    //成员变量
    private T[] items;
    private int N;

    //构造方法
    public MinPriorityQueue(int capacity){
        this.items= (T[]) new Comparable[capacity+1];
        this.N=0;
    }

    //判断索引的i处的值是否小于j处的值
    private boolean less(int i , int j){
        return items[i].compareTo(items[j])<0;
    }

    //交换索引处的值
    private void exch(int i ,int j){
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }
    //删除最小值，最小优先队列，类似最小堆，1索引处即为最小值
    public T delMin(){
        T min = items[1];
        exch(1,N);
        N--;
        //变换后让1索引下沉 使其符合最小优先队列，（最小堆）
        sink(1);

        return min;
    }

    //插入一个元素
    public void insert(T t){
        items[++N] = t;
        //插入后上浮
        swim(N);
    }

    //最小堆的上浮，上浮较小的节点
    private void swim(int k){
        while (k>1){
            if (less(k/2,k)){
                break;
            }else {
                exch(k/2,k);
            }
            k /= 2;
        }
    }
    //最小堆的下沉，下沉较大的节点
    private void sink(int k){
        while (2 * k <= N) {
            //记录子节点的最小值
            int min = 0;
            if (2*k+1<=N){
                if (less(2*k,2*k+1)){
                    min = 2*k;
                }else {
                    min = 2*k+1;
                }
            }else {
                min = 2*k;
            }

            if (less(k,min)){
                break;
            }else {
                exch(k,min);
            }

            k = min;
        }
    }

    //获取队列中元素个数
    public int size(){
        return N;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }
}
