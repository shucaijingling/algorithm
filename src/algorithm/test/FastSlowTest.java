package algorithm.test;


public class FastSlowTest {
    public static void main(String[] args) {
        Node first = new Node("aa", null);
        Node second = new Node("bb", null);
        Node third = new Node("cc", null);
        Node fourth = new Node("dd", null);
        Node fifth = new Node("ee", null);
        Node six = new Node("ff", null);
        Node seven = new Node("gg", null);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        seven.next = third;


        /*String mid = getMid(first);
        System.out.println("中间值为： " + mid);*/

        String c = getCircle(first);
        System.out.println("中间值为： " + c);

    }

    /**
     * 快慢指针查找链表中间值
     * 链表为无环链表
     *
     * @param first
     * @return
     */
    public static String getMid(Node<String> first) {
        Node<String> slow = first;
        Node<String> fast = first;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.item;
    }


    public static class Node<T> {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
     * 快慢指针查找有环链表,环入口
     */
    public static String getCircle(Node<String> first) {
        Node<String> slow = first;
        Node<String> fast = first;
        Node<String> circle = null;
        /*while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                break;
            }
        }
        Node<String> circle = first;
        while (circle != slow){
            circle = circle.next;
            slow = slow.next;
        }*/

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                circle = first;
                continue;
            }
            if (circle != null) {
                circle = circle.next;
                if (circle.equals(slow)) {
                    break;
                }
            }

        }
        return circle.item;
    }

}
