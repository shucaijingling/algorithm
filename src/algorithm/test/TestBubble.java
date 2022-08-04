package algorithm.test;

import algorithm.sort.*;

import java.util.Arrays;

public class TestBubble {
    public static void main(String[] args) {
        Integer[] a = {4,5,6,3,2,1};
        Bubble.sort(a);
        System.out.println("Bubble == > " + Arrays.toString(a));

        Integer[] b = {4,6,8,7,9,2,10,1};
        Selection.sort(b);
        System.out.println("Selection == > " + Arrays.toString(b));

        Integer[] c = {4,3,2,10,12,1,5,6};
        Insertion.sort(c);
        System.out.println("Insertion == > " + Arrays.toString(c));

        Integer[] d = {9,1,2,5,7,4,8,6,3,5};
        Shell.sort(d);
        System.out.println("Shell == > " + Arrays.toString(d));

        Integer[] e = {8,4,5,7,1,3,6,2};
        Merge.sort(e);
        System.out.println("Merge == > " + Arrays.toString(e));

        Integer[] f = {6,1,2,7,9,3,4,5,8};
        Quick.sort(f);
        System.out.println("Quick == > " + Arrays.toString(f));
    }
}
