package algorithm.test;

import algorithm.tree.BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer,String> tree = new BinaryTree<>();

        tree.put(1,"张三");
        tree.put(2,"李四");
        tree.put(3,"王五");
        tree.put(4,"王五");
        tree.put(5,"王五");
        tree.put(100,"王五");
        tree.put(50,"王五");
        tree.put(53,"王五");
        tree.put(2,"王五");
        System.out.println(tree.size());

        System.out.println(tree.get(2));

        tree.delete(3);
        tree.delete(4);
        tree.delete(5);
        System.out.println(tree.size());

        System.out.println(tree.min());
        System.out.println(tree.max());
    }
}
