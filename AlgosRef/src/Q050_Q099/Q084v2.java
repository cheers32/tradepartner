package Q050_Q099;

import java.util.Stack;

public class Q084v2 {  // this is a stack increasing sequence N solution
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }
        int res = 0;
        Stack<int[]> stack = new Stack<>();  // value, index
        Integer prev = Integer.MIN_VALUE;  // no need to use prev
        for(int i=0; i<heights.length; i++) {
            Integer cur = heights[i];
            if(stack.size() == 0 || cur > stack.peek()[0]) {  // push only for increasing sequence
                stack.push(new int[]{cur,i});
            }
            else if (cur == stack.peek()[0]) {  // no action needed if equal
            }
            else {  // decreasing, evaluate all results until forming a new increasing sequence
                int prevIdx = 0;  // this is useful, and needs to set this value after the while loop, so place it outside
                while(stack.size()>0 && stack.peek()[0]>cur) {  // standard stack checking condition
                    int[] top = stack.pop();
                    int width = i-top[1];
                    int size = width * top[0];
                    res = Math.max(size, res);
                    prevIdx = top[1];
                }
                stack.push(new int[]{cur, prevIdx});
            }
        }
        while(stack.size()>0) {  // handle after all nums were pushed
            int[] top = stack.pop();
            int width = heights.length-top[1];
            int size = width * top[0];
            res = Math.max(size, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Q084v2().largestRectangleArea(new int[] {1,4,6,6,6,19,10,2,2,2});
        System.out.println(res);
    }
}
