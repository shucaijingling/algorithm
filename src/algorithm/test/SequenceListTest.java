package algorithm.test;

import algorithm.linear.SequenceList;

public class SequenceListTest {
    public static void main(String[] args) {

        SequenceList<String> sl = new SequenceList<>(10);

        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("麦迪");
        sl.insert(1,"詹姆斯");
        for (String s : sl) {
            System.out.println(s);

        }

        String getResult = sl.get(1);
        System.out.println("获取索引1处的结果为：" + getResult);

        String remove = sl.remove(0);
        System.out.println("删除的元素是：" +remove);

        sl.clear();
        System.out.println("清空后线性表中的元素个数为："+ sl.length());

    }
}
