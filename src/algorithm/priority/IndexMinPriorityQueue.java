package algorithm.priority;

public class IndexMinPriorityQueue<T extends Comparable<T>> {

    //成员变量
    //用来存储元素的数组
    private T[] items;
    //保存每个元素在items数组中的索引，p数组需要堆排序
    private int[] p;
    //保存p的逆序，p的值作为索引，p的索引作为值
    private int[] q;
    //记录堆中元素的个数
    private int N;

    //构造方法
    //创建容量为capacity的IndexMinPriorityQueue对象
    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.p = new int[capacity + 1];
        this.q = new int[capacity + 1];
        this.N = 0;

        for (int i = 0; i < p.length; i++) {
            //初始化，q记录的值是堆中的索引，-1即为不存在
            q[i]=-1;
        }
    }

    //判断堆中索引i处是否小于索引j处的元素
    private boolean less(int i, int j) {
        return items[p[i]].compareTo(items[p[j]]) < 0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i, int j) {
        int tmp = p[i];
        p[i] = p[j];
        p[j] = tmp;

        q[p[i]] = i;
        q[p[j]] = j;


    }

    //删除队列中最小的元素，并返回该元素关联的索引
    public int delMin() {

        int min = p[1];
        exch(1,N);
        items[min]=null;
        q[p[N]]=-1;
        p[N]=-1;

        N--;
        sink(1);
        return min;
    }

    //往队列中插入一个元素，并关联索引
    public void insert(int i, T t) {
        if (contains(i)){
            return;
        }
        N++;
        items[i] = t;
        //插入到堆尾
        p[N] = i;
        q[i] = N;

        //上浮
        swim(N);
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k) {

        while (k>1){
            if (less(k,k/2)){
                exch(k,k/2);
            }
            k /= 2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k) {
        while (2 * k <= N) {
            int min;
            if (2 * k + 1 <= N) {
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

    //获取所列中元素的个数
    public int size() {
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return N==0;
    }

    //判断k对应的元素是否存在
    public boolean contains(int k) {
        return q[k]!=-1;
    }

    //把与索引i关联的元素修改为t
    public void changeItem(int i, T t) {
        items[i] = t;
        int k = q[i];
        swim(k);
        sink(k);
    }

    //最小元素关联的索引
    public int minIndex() {
        return p[1];
    }

    //删除索引i关联的元素
    public void delete(int i) {

        int k = q[i];
        exch(k,N);
        q[p[N]] = -1;
        p[N] = -1;
        items[i] = null;
        N--;
        sink(k);
    }
}
