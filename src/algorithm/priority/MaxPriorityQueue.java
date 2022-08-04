package algorithm.priority;

/**
 * 最大优先队列，最大堆
 * @param <T>
 */
public class MaxPriorityQueue<T extends Comparable<T>> {
    //成员变量
    //用来存储元素的数组
    private T[] items;
    //记录堆中元素的个数
    private int N;

    //构造方法
    //创建容量为capacity的MaxPriorityQueue对象
    public MaxPriorityQueue(int capacity){
        //初始化，item数组长度为容量+1，堆特性，废弃0处索引
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i, int j){
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }
    //删除队列中最大的元素，并返回这个最大元素
    public T delmax(){
        //根据堆特性，索引1处的即为最大元素
        T max = items[1];
        //交换索引1和最大索引处的值
        exch(1,N);
        //删除后，长度减1，
        N--;
        //使交换后的1索引处的元素进行下沉
        sink(1);

        //返回删除的元素
        return max;
    }

    //插入一个元素
    public void insert(T t){
        //因为堆废弃了0索引 所以添加从1索引开始
        items[++N] = t;
        //添加后为了满足堆的性质，使其上浮到正确位置
        swim(N);
    }
    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        //判断k是不是大于1,1为根节点不用上浮
        while (k>1){
            //判断k节点父节点的值是自己小，小就交换
            if (less(k/2,k)){
                exch(k/2,k);
            }
            //交换后吧自己变为父节点 继续循环
            k /= 2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        //判断是否存在左子节点，存在就进入循环
        while (2*k<=N){
            //记录最大值，因为传入的k节点要与自己的左右节点最大值交换
            int max;
            //判断是否存在右子节点，存在就比较
            if (2*k+1<=N){
                //比较左右节点的值
                if (less(2*k,2*k+1)){
                    //如果右节点大，就记录最大值为右节点
                    max = 2*k+1;
                }else {
                    //左节点大就记录左节点为最大值
                    max = 2*k;
                }
            }else {
                //如果不存在右节点就记录左结点为最大
                max = 2*k;
            }
            //判断k节点的值和其子节点的最大值，k节点比子节点小就交换，大就跳出循环
           if (less(k,max)){
              exch(k,max);
           }else {
               break;
           }

           //把交换后的max标记为k节点继续循环
            k = max;
        }
    }
    //获取碎裂中元素的个数
    public int size(){
        return N;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }
}
