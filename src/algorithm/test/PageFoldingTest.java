package algorithm.test;

import algorithm.linear.Queue;

/**
 * 对折问题
 */
public class PageFoldingTest {

    //main
    public static void main(String[] args) {

        Node<String> tree = createTree(3);
        printTree(tree);

    }
    //创建树
    public static Node<String> createTree(int N){
        Node<String> root = null;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                root = new Node<String>("down",null,null);
                continue;
            }
            Queue<Node> nodes = new Queue<Node>();
            nodes.enqueue(root);
            while (!nodes.isEmpty()){
                Node n = nodes.dequeue();

                if (n.left != null) {
                    nodes.enqueue(n.left);
                }
                if (n.right != null) {
                    nodes.enqueue(n.right);
                }
                if (n.left == null && n.right == null) {
                    n.left = new Node("down",null,null);
                    n.right = new Node("up",null,null);

                }
            }
        }
        return root;

    }
    //打印树
    public static void printTree(Node<String> root){
        if (root == null) {
            return;
        }

        if (root.left != null) {
            printTree(root.left);
        }
        System.out.print(root.item+"  ");

        if (root.right != null) {
            printTree(root.right);
        }

    }
    //节点类
    public static class Node<T>{
       private T item;
       private Node left;
       private Node right;

       public Node(T t,Node left,Node right){
           this.item = t;
           this.left = left;
           this.right = right;
       }
    }


}
