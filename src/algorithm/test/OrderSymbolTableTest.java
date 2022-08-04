package algorithm.test;

import algorithm.linear.OrderSymbolTable;

public class OrderSymbolTableTest {
    public static void main(String[] args) {
        OrderSymbolTable<Integer,String> table = new OrderSymbolTable<>();

        table.put(1,"张三");
        table.put(2,"李四");
        table.put(4,"赵六");
        table.put(5,"田七");
        table.put(3,"王五");
    }
}
