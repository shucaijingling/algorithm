package algorithm.test;

import algorithm.linear.LinkList;
import algorithm.linear.SequenceList;

public class LinkListTest {
    public static void main(String[] args) {

        LinkList<String> sl = new LinkList<>();

        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("麦迪");
        sl.insert(1,"詹姆斯");
        for (String s : sl) {
            System.out.println(s);

        }

        System.out.println("===================");
        String getResult = sl.get(0);
        String getResult1 = sl.get(1);
        String getResult2 = sl.get(2);
        String getResult3 = sl.get(3);
        System.out.println("获取索引1处的结果为：" + getResult);
        System.out.println("获取索引1处的结果为：" + getResult1);
        System.out.println("获取索引1处的结果为：" + getResult2);
        System.out.println("获取索引1处的结果为：" + getResult3);
        System.out.println("================================");

        String remove = sl.remove(0);
        System.out.println("删除的元素是：" +remove);

        sl.clear();
        System.out.println("清空后线性表中的元素个数为："+ sl.length());

    }
}
