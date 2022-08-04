package algorithm.sort;

/**
 * 快速排序
 */
public class Quick {
    public static void sort(Comparable[] a){

        int lo = 0;
        int hi = a.length - 1;
        sort(a,lo,hi);
    }

    private static void sort(Comparable[] a,int lo, int hi){
        //安全校验
        while (hi <= lo){
            return;
        }
        //分界值所在的索引
        int partition = partition(a, lo, hi);
        sort(a,lo,partition-1);
        sort(a,partition+1,hi);

    }
    private static int partition(Comparable[] a,int lo, int hi){
        Comparable key = a[lo];
        int left = lo;
        int right = hi+1;
        while (true){
            while (less(key,a[--right])){
                if (right==lo){
                    break;
                }
            }
            while (less(a[++left],key)){
                if (left == hi){
                    break;
                }
            }

            if (left>=right){
                break;
            }else {
                exch(a,left,right);
            }
        }
        exch(a,lo,right);
        return right;
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a,int i ,int j){
        Comparable t;
        t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
