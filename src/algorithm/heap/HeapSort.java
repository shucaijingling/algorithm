package algorithm.heap;

import algorithm.sort.Merge;

public class HeapSort<T extends Comparable<T>> {
    //堆source数组中的数据从小到大排序
    public static void sort(Comparable[] source) {
        //排序，使堆严格有序，从小到大
        Comparable[] heap = new Comparable[source.length+1];
        createHeap(source,heap);
        //循环遍历，进行排序
        int N = heap.length -1; //将最大索引标记为N
        //遍历到1索引就结束，1不用排序，到1时已经排序完成
        while (N!=1){
            //将1索引处的元素（根据堆特性，1索引处的元素为最大元素）和最大索引N处的元素进行交换
            exch(heap,1,N);
            //交换后的N处索引满足从小到大的顺序，之后的排序就不用参加了
            N--;
            //交换后1索引处的元素不符合堆的特性，所以将其下沉至正确的位置
            sink(heap,1,N);
        }
        //遍历结束后，此时的堆数组，heap满足从小到大排序
        //将heap数组拷贝到原数组，此时的原数组就是堆排序后的数组
        System.arraycopy(heap,1,source,0,source.length);

    }

    //根据原数组source，构造处堆heap
    private static void createHeap(Comparable[] source, Comparable[] heap) {

        //把需要排序的数组 复制到堆中，方便进行堆排序
        System.arraycopy(source, 0, heap, 1, source.length);

        /**
         * 构造时进行排序，排序后，只是符合堆的特性(此时的顺序，父节点比子节点大)，此时还没有排序
         */
        //遍历1-N/2索引的元素

        for (int i = heap.length/2; i >0 ; i--) {
            sink(heap,i,heap.length-1);
        }
    }

    //判断heap堆中索引i处的元素是否小于索引j处的元素
    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    //交换heap堆中i索引和j索引处的值
    private static void exch(Comparable[] heap, int i, int j) {
        Comparable tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    //在heap堆中，对target处的元素左下沉，范围是0-target
    private static void sink(Comparable[] heap, int target, int range) {

        while (2 * target <= range) {
            int max;
            if (2 * target + 1 <= range) {
                if (less(heap,2 * target, 2 * target + 1)) {
                    max = 2 * target + 1;
                } else {
                    max = 2 * target;
                }
            }else {
                max = 2*target;
            }

            //目标比子节点小就交换
            if (less(heap,target,max)){
                exch(heap,target,max);
            }else {
                break;
            }

            target = max;
        }
    }
}
