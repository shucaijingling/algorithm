package algorithm.test;

import algorithm.sort.Student;

/**
 * 定义测试类Test，再测试类Test中定义测试方法Comparable getMax(Comparable c1,Comparable c2) 完成测试
 */
public class TestComparable {

    public static void main(String[] args) {
        //创建两个Student对象，并调用getMax方法比较对象的年龄大小
        Student student1 = new Student();
        Student student2 = new Student();

        student1.setUsername("Dio");
        student1.setAge(100);
        student2.setUsername("jojo");
        student2.setAge(50);

        Comparable max = getMax(student1, student2);
        System.out.printf("max ==> " + max);
    }


    public static Comparable getMax(Comparable c1,Comparable c2){
        int result = c1.compareTo(c2);
        //result<0，则c1 小于 c2
        //result>0，则c1 大于 c2
        //result==0，则c1 等于 c2
        if (result >= 0) {
            return c1;
        }else {
            return c2;
        }
    }
}
