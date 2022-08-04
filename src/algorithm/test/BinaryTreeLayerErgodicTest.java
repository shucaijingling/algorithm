package algorithm.test;

import algorithm.linear.Queue;
import algorithm.tree.BinaryTree;

public class BinaryTreeLayerErgodicTest {
    public static void main(String[] args) {
        BinaryTree<String, String> tree = new BinaryTree<>();

        tree.put("E","5");
        tree.put("B","2");
        tree.put("G","7");
        tree.put("A","1");
        tree.put("D","4");
        tree.put("F","6");
        tree.put("H","8");
        tree.put("C","3");

        Queue<String> strings = tree.layerErgodic();
        for (String string : strings) {
            String str = tree.get(string);
            System.out.println(string+"::"+str);
        }
    }
}
