package algorithm.sort;

/**
 * 选择排序
 */
public class Selection {

    /**
     * 对数组内的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a){
        for (int i = 0; i <= a.length - 2; i++) {
            //定义一个变量，记录最小值索引；
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (greater(a[minIndex],a[j])){
                    minIndex = j;
                }

            }
            exch(a,i,minIndex);
        }
    }

    /**
     * 判断v是否大于w
     * @param v
     * @param w
     * @return
     */
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w) > 0;
    }

    /**
     * 交换数组索引i和j的值
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i ,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
}
