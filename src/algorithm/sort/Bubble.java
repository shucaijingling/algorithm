package algorithm.sort;

/**
 * 冒泡排序
 */
public class Bubble {
    /**
     * 对数组a中的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a) {

        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }

    /**
     * 比较v元素是否大于w元素
     * @param v
     * @param w
     * @return
     */
    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * 交换i,j元素
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {

        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
