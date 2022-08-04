package algorithm.test;

import algorithm.linear.LinkList;
import algorithm.linear.TowwayLinkList;

public class TowwayLinkListTest {
    public static void main(String[] args) {

        TowwayLinkList<String> sl = new TowwayLinkList<>();

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
/*        String getResult4 = sl.get(4);*/
        System.out.println("获取索引0处的结果为：" + getResult);
        System.out.println("获取索引1处的结果为：" + getResult1);
        System.out.println("获取索引2处的结果为：" + getResult2);
        System.out.println("获取索引3处的结果为：" + getResult3);
/*        System.out.println("获取索引4处的结果为：" + getResult4);*/
        System.out.println("================================");

        System.out.println("第一个：" + sl.getFirst());
        System.out.println("最后一个：" + sl.getLast());

        String remove = sl.remove(0);
        System.out.println("删除的元素是：" +remove);
        System.out.println("========================================");
        sl.clear();
        System.out.println("清空后线性表中的元素个数为："+ sl.length());


    }
}
