package Q200_Q249;

import java.util.Stack;

public class Q224copy {
    public int calculate(String s) {  // N，这个方法虽然好，但是并不直观，扩展性也不强，这个强行推出每个数字队最终结果的影响，我不是很喜欢
        if(s == null) return 0;

        int result = 0;
        int sign = 1;
        int num = 0;

        Stack<Integer> stack = new Stack<>();  // this is a stack of signs
        stack.push(sign);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');

            } else if(c == '+' || c == '-') {
                result += sign * num;  // current accumulated number to be added back to result
                sign = stack.peek() * (c == '+' ? 1: -1);  // prepare sign to be pushed or used
                num = 0;  // reset accumulated number
            } else if(c == '(') {
                stack.push(sign);  // this stack looks like only contains +1 or -1
            } else if(c == ')') {
                stack.pop();
            }
        }

        result += sign * num;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Q224copy().calculate("14-2"));
        System.out.println(new Q224copy().calculate("14-(2-(3-1))"));
        //System.out.println(new Q224copy().calculate("14-(2+3)"));
//        System.out.println(new Q224copy().calculate("14-(2+(3-4))-5"));
//        System.out.println(new Q224copy().calculate("-2"));
//        System.out.println(new Q224copy().calculate("5-(12-13)"));
    }
}
