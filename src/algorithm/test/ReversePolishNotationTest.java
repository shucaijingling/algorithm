package algorithm.test;

import algorithm.linear.Stack;

public class ReversePolishNotationTest {
    public static void main(String[] args) {
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = calculate(notation);
        System.out.println(result);
    }

    public static int calculate(String[] nonation) {
        Stack<Integer> stack = new Stack<>();

        for (String s : nonation) {
            Integer first = null;
            Integer second = null;
            Integer result = null;
            switch (s) {
                case "+":
                    first = stack.pop();
                    second = stack.pop();
                    result = second + first;
                    stack.push(result);
                    break;
                case "-":
                    first = stack.pop();
                    second = stack.pop();
                    result = second - first;
                    stack.push(result);
                    break;
                case "*":
                    first = stack.pop();
                    second = stack.pop();
                    result = second * first;
                    stack.push(result);
                    break;
                case "/":
                    first = stack.pop();
                    second = stack.pop();
                    result = second / first;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }

        }

        int result = stack.pop();
        return result;
    }
}
