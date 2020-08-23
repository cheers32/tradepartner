package Q150_Q199;

import java.util.Stack;

public class Q155 {
    static class MinStack {  // 2N space, constant time
        Stack<Integer> stack;
        Stack<Integer> min;

        /** initialize your data structure here. */
        public MinStack() {  // easy solution, 2N space, constant time
            stack = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            if(min.isEmpty() || x<=min.peek()) {  // this <= is critical, because it needs to push duplicate mins in to min stack
                min.push(x);
            }
            stack.push(x);
        }

        public void pop() {
            if(stack.isEmpty())
                return;
            int top = stack.pop();
            if(top==min.peek()) // very important, if using Integer, must use equals
                min.pop();
        }

        public int top() {
            if(stack.isEmpty())
                return 0;
            return stack.peek();
        }

        public int getMin() {
            if(min.isEmpty())
                return 0;
            return min.peek();
        }
    }

    public static void main(String[] args) {
        Q155.MinStack ms = new Q155.MinStack();
        System.out.println(ms.top());
        ms.push(512);
        //System.out.println(ms.getMin());
        ms.push(-1024);
        //System.out.println(ms.getMin());
        //ms.push(-1024);
        //System.out.println(ms.getMin());
        ms.push(512);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
    }
}
