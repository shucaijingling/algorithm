package algorithm.linear;

/**
 * 符号表 SymbolTable，头插法,无序
 * @param <Key>
 * @param <Value>
 */
public class SymbolTable<Key, Value> {
    //成员变量 头节点
    private Node head;
    //键值对个数
    private int N;

    //构造方法
    public SymbolTable() {
        //初始化
        this.head = new Node(null,null,null);
        this.N = 0;
    }

    //节点类
    private class Node<Key, Value> {
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }

    //通过键获得值
    public Value get(Key key){
        Node n = head;
        while (n.next!=null){
            n = n.next;
            if (n.key.equals(key)){
                return (Value) n.value;
            }
        }
        return null;
    }

    //向表中插入一个键值对
    public void put(Key key,Value value){
        //遍历符号表，如果存在键为key的键值对，就覆盖其value值。
        Node n = head;
        while (n.next!=null){
            n = n.next;
            if (n.key.equals(key)){
                n.value = value;
                return;
            }
        }
        //不存在key键 就在头部插入节点
        Node newNode = new Node(key,value,null);
        Node oldFirst = head.next;
        head.next = newNode;
        newNode.next = oldFirst;
        N++;
    }

    //删除键为key的键值对
    public void delete(Key key){
        //key存在
        Node n = head;
        Node pre = null;
        while (n.next!=null){
            pre = n;
            n = n.next;
            if (n.key.equals(key)){
                pre.next = n.next;
                N--;
                return;
            }else {
                System.out.println("不存在");
                return;
            }
        }


    }

    //获取符号表的大小
    public int size(){
        return N;
    }

}
