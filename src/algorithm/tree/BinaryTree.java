package algorithm.tree;

import algorithm.linear.Queue;

public class BinaryTree<Key extends Comparable<Key>, Value> {

    //二叉树的成员变量
    //根节点
    private Node root;
    //数中元素的个数
    private int N;

    /*//二叉树的构造方法
    public BinaryTree() {
        //初始化
        this.root = new Node(null, null, null, null);
        this.N = 0;
    }*/

    //节点类
    private class Node {
        //键
        public Key key;
        //值
        private Value value;
        //左节点
        public Node left;
        //右节点
        public Node right;

        //节点类构造方法
        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;

        }
    }


    //向树中插入一个键值对
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //给指定树x上，添加一个键值对，并返回添加后的新树
    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        if (key.compareTo(x.key) > 0) {
            x.right = put(x.right, key, value);
        } else if (key.compareTo(x.key) < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.value = value;
        }

        return x;
    }

    //根据key，从树中找出对应的值
    public Value get(Key key) {
        return get(root, key);
    }

    //从指定的树x中，找出key对应的值
    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.value;
        }
    }

    //根据key，删除树中对应的键值对
    public void delete(Key key) {
        delete(root, key);

    }

    //删除指定树x上的键为key的键值对，并返回删除后端新树
    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            x.left = delete(x.left, key);
        } else {
            N--;
            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }
            //如果删除的节点，存在左子树和右子树，此时需要一个数，这个数是此节点的左子树的最大值，
            // 或者是此节点的右子树的最小值
            Node min = x.right;
            while (min.left != null) {
                min = min.left;
            }
            //删除右子树的最小节点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }

            min.left = x.left;
            min.right = x.right;
            x = min;


        }
        return x;
    }

    //数中元素的个数
    public int size() {
        return N;
    }

    //最小的键
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left != null) {
            return min(x.left);
        } else {
            return x;
        }
    }

    //最大的键
    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right != null) {
            return max(x.right);
        }else {
            return x;
        }
    }

    //前序遍历
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue<>();
        preErgodic(root,keys);
        return keys;
    }

    private void preErgodic(Node x,Queue<Key> keys){
        if (x == null) {
            return;
        }
        keys.enqueue(x.key);
        if (x.left != null) {
            preErgodic(x.left,keys);
        }

        if (x.right != null) {
            preErgodic(x.right,keys);
        }
    }

    //中序遍历
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue<>();
        midErgodic(root,keys);
        return keys;
    }

    private void midErgodic(Node x,Queue<Key> keys){
        if (x == null) {
            return;
        }

        if (x.left != null) {
            midErgodic(x.left,keys);
        }

        keys.enqueue(x.key);

        if (x.right != null) {
            midErgodic(x.right,keys);
        }
    }


    //后序遍历
    public Queue<Key> aftErgodic(){
        Queue<Key> keys = new Queue<>();
        aftErgodic(root,keys);
        return keys;
    }

    private void aftErgodic(Node x,Queue<Key> keys){
        if (x == null) {
            return;
        }

        if (x.left != null) {
            aftErgodic(x.left,keys);
        }


        if (x.right != null) {
            aftErgodic(x.right,keys);
        }
        keys.enqueue(x.key);
    }

    //层序遍历
    public Queue<Key> layerErgodic(){
        //定义两个队列，一个放节点，一个放key
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();
        //1.先把根节点root存入节点队列
        nodes.enqueue(root);
        //循环遍历节点队列，
        while (!nodes.isEmpty()){
            //不为空，就弹出一个节点
            Node n = nodes.dequeue();
            //把弹出节点的key存入key队列，
            keys.enqueue(n.key);
            // 并且判断这个节点是否有左字节点
            if (n.left != null) {
                //有就把左子节点存入节点队列
                nodes.enqueue(n.left);
            }
            //判断这个节点是否有右子节点，有就存入节点队列
            if (n.right != null) {
                nodes.enqueue(n.right);
            }
        }

        //返回key队列
        return keys;
    }

    //最大深度
    public int maxDepth(){
        return maxDepth(root);
    }

    private int maxDepth(Node x){
        //传入节点为空，没有深度
        if (x == null) {
            return 0;
        }
        int letf = maxDepth(x.left);
        int rigeht = maxDepth(x.right);

        return letf > rigeht ? letf + 1: rigeht + 1;

    }
}
