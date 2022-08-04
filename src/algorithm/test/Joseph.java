package algorithm.test;

/**
 * 约瑟夫问题，41个人排成一圈从1开始数到3，第三位出局，并从他下一位重新开始数，最后剩余一位
 */
public class Joseph {

    public static void main(String[] args) {
        //定义第一个节点
        Node<Integer> first = null;
        //定义前节点
        Node<Integer> pre = null;
        for (int i = 1; i <= 41; i++) {
            //第一个节点
            if (i == 1) {
                first = new Node<>(i, null);
                pre = first;
                continue;
            }
            //不是第一个节点
            Node<Integer> newNode = new Node<>(i, null);
            //第一节点指向新节点
            pre.next = newNode;
            //新节点变为前节点
            pre = newNode;
            //最后一个节点
            if (i == 41) {
                pre.next = first;
            }
        }

        //报数
        //计数器
        int count = 0;
        //记录节点，从第一节点开始
        Node<Integer> n = first;
        Node<Integer> before = null;
        while (n!=n.next){
            if (++count == 3){
                before.next = n.next;
                System.out.print(n.item + ",");
                count=0;
                n=n.next;
            }else {
                before = n;
                n = n.next;
            }

        }
        System.out.println(n.item);
    }

    public static class Node<T> {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;

        }
    }
}
