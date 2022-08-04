package algorithm.test;

import algorithm.linear.SymbolTable;

public class SymbolTableTest {
    public static void main(String[] args) {
        //创建对象
        SymbolTable<Integer,String> symbolTable = new SymbolTable<>();

        //插入键值对
        symbolTable.put(1,"aa");
        symbolTable.put(2,"bb");
        symbolTable.put(13,"cc");
        symbolTable.put(4,"dd");

        System.out.println(symbolTable.size());

        System.out.println("===============");
        symbolTable.delete(5);
        System.out.println(symbolTable.size());

        String s = symbolTable.get(13);
        System.out.println(s);

    }


}
