package Q200_Q249;

import java.util.Stack;

public class Q224 {
    public int calculate(String s) {  // N， 我写的这个标准双栈方法应该是非常直观易用的
        if(s == null)
            return 0;

        Stack<int[]> ops = new Stack<>();  // this is a stack of operators
        Stack<Integer> nums = new Stack<>();  // this is a stack of operands
        int level = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int num = 0;
                int k = i;
                while(k<s.length() && Character.isDigit(s.charAt(k))) {
                    c = s.charAt(k);
                    num = num * 10 + (c - '0');
                    k++;
                }
                nums.push(num);
                i = k-1;
            }
            else if(c == '(') {
                level++;
            } else if(c == ')') {
                level--;
            } else if(c == '+' || c == '-' || c == '*' || c == '/') {
                while(!ops.isEmpty() && ops.peek()[1]>=level) {
                    evaluate(ops, nums);
                }
                ops.push(new int[]{c, level});
            }
        }
        while(!ops.isEmpty()) {
            evaluate(ops, nums);
        }
        return nums.pop();
    }

    void evaluate(Stack<int[]> ops, Stack<Integer> nums) {
        int[] item = ops.pop();
        char op = (char)item[0];
        int num2 = nums.pop();
        int num1 = nums.pop();
        if(op=='+')
            nums.push(num1+num2);
        else if(op=='-')
            nums.push(num1-num2);
        else if(op=='*')
            nums.push(num1*num2);
        else if(op=='/')
            nums.push(num1/num2);
    }

    public static void main(String[] args) {
        System.out.println(new Q224().calculate("3+(14/(2-4))"));  // 这种乘除运算，还是得加一个括号，不过我很喜欢我做的方法
        System.out.println(new Q224().calculate("14/2"));
        System.out.println(new Q224().calculate("14*2"));
        //System.out.println(new Q224().calculate("14-2"));
        //System.out.println(new Q224().calculate("14-(2-(3-1))"));
        //System.out.println(new Q224().calculate("14-(2-5)-1)"));
        //System.out.println(new Q224copy().calculate("14-(2+3)"));
//        System.out.println(new Q224copy().calculate("14-(2+(3-4))-5"));
//        System.out.println(new Q224copy().calculate("-2"));
//        System.out.println(new Q224copy().calculate("5-(12-13)"));
    }
}
