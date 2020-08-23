package Q200_Q249;

import java.util.Stack;

public class Q232 {
    class MyQueue {  // push time is N, others are 1. 这个题开始我想错了，后来用了三个数才发现问题。

        Stack<Integer> stack;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            Stack<Integer> temp = new Stack<>();  // 这里的临时栈的使用方法就是负责储存现有的，然后还要放回去，与那个queue->stack的用法不同
            while(!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            stack.push(x);
            while(!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return stack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return stack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
