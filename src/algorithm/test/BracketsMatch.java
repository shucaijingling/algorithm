package algorithm.test;

import algorithm.linear.Stack;

import java.util.Arrays;

public class BracketsMatch {
    public static void main(String[] args) {
        String str = "(上海(长安)())(";
        boolean match = isMatch(str);
        System.out.println(match);
    }

    public static boolean isMatch (String str){
        //创建栈
        Stack<String> stack = new Stack<>();
        //扫描字符串，出现左括号就压栈
        for (int i = 0; i < str.length(); i++) {
            String c = str.charAt(i) + "";
            /*if (c.equals(")")){
                stack.push("false");
                break;
            }*/
            if (c.equals("(")){
                stack.push(c);
            }else if (c.equals(")")){
                String pop = stack.pop();
                if (pop == null) {
                    return false;
                }
            }
        }

        /*char[] array = str.toCharArray();
        for (char ch:array){
            if (ch == ')'){
                stack.push("false");
                break;
            }
            if (ch == '('){
                stack.push("(");
            }
            //出现右括号就弹栈
            if (ch == ')'){
                stack.pop();
            }
        }*/


        //查看栈的大小 为0即为成对出现
        return stack.isEmpty();
    }
}
