package Q200_Q249;

import java.util.LinkedList;
import java.util.Queue;

public class Q225
{
    class MyStack {  // 这个题就是每次用一个临时queue，把新的数先加进来，然后后面都进来，就好像是insert to 0 idx 一样

        Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {  // N time
            Queue<Integer> temp = new LinkedList<>();
            temp.offer(x);
            while(!queue.isEmpty()) {
                temp.offer(queue.poll());
            }
            queue = temp;  // 这个直接替换很重要
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
