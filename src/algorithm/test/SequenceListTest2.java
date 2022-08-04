package algorithm.test;

import algorithm.linear.SequenceList;

public class SequenceListTest2 {
    public static void main(String[] args) {

        SequenceList<String> sl = new SequenceList<>(3);

        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("麦迪");
        sl.insert("詹姆斯");

    }
}
