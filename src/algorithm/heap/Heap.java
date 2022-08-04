package algorithm.heap;

public class Heap<T extends Comparable<T>> {
    //成员变量
    //用来存储元素的数组
    private T[] items;
    //记录堆中元素的个数
    private int N;

    //构造方法
    //创建容量为capacity的Heap对象
    public Heap(int capacity){
        //初始化
        //堆是用数组实现，创建一个容量为capacity的数组
        this.items = (T[]) new Comparable[capacity+1];
        //N初始为0
        this.N = 0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i , int j){
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    //删除堆中最大的元素，并返回这个最大元素
    public T delMax(){
        //索引1处的就是最大元素
        T max = items[1];
        // 将索引N处的元素跟最大元素交换，并将索引N处的元素下沉
        exch(1,N);
        //交换后索引为N处的元素的索引为1；
        items[N] = null;
        N--;
        sink(1);
        return max;
    }

    //往堆中插入一个元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }
    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){

        //比较当前节点和其父节点，如果比父节点大就交换
        //最后比到根节点结束
        while (k > 1) {
            if (less(k/2,k)){
                exch(k/2,k);
            }
            k /= 2;
        }
    }
    //使用下沉算法，使索引k处的元素能在对重处于一个正确的位置
    private void sink(int k){
        //判断索引k处的元素存在左结点，比较 当前节点的元素 与其左右节点的最大值 ，比最大值小就交换
        while (2 * k <= N) {
            int max = 0;
            if (2 * k + 1 <= N) {
                if (less(2*k,2*k+1)){
                    max = 2*k+1;
                }else {
                    max = 2*k;
                }
            }else {
                max = 2*k;
            }
            //比较，交换
            if (less(k, max)) {
                exch(k,max);
            }
            k = max;
        }
    }

}
