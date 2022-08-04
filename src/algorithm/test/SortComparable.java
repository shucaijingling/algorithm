package algorithm.test;

import algorithm.sort.Insertion;
import algorithm.sort.Shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 测试不同排序的所需的时间
 */
public class SortComparable {
    public static void main(String[] args) throws IOException {
        //创建ArrayList集合
        ArrayList<Integer> list = new ArrayList<>();

        //创建缓存读取流，读取数据存入集合
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(SortComparable.class.getClassLoader().getResourceAsStream("test.txt")));


        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            //line是字符串，要转换成Integer
            int i = Integer.parseInt(line);
            list.add(i);
        }
        bufferedReader.close();

        //集合转化成数组
        Integer[] a = new Integer[list.size()];
        list.toArray(a);
        //测试方法
        testInsertion(a);
        testShell(a);
    }

    public static void testShell(Integer[] a){
        long start = System.currentTimeMillis();
        Shell.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("ShellTime == > " + (end - start));//7
    }

    public static void testInsertion(Integer[] a){
        long start = System.currentTimeMillis();
        Insertion.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("InsertionTime == > " + (end - start)); //19029
    }
}
