package Q200_Q249;

import java.util.ArrayDeque;
import java.util.Deque;

import static ds.ArrayUtil.printArray;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) { // N, solved it myself after learning the approach, 简而言之，就是queue里的idx值对应的数应该是递减的
        if (nums == null || nums.length==0) {  // 我以前用sorted list做过，可以滑动，但java不行
            return new int[0];
        }
        int[] res = new int[nums.length-k+1];  // as required by ps
        int idx = 0;
        Deque<Integer> dq = new ArrayDeque<>();  // stores index, decreasing order for its value
        for(int i=0; i<nums.length; i++) {  // this i tracks the end of this window, // this should loop to end
            while(!dq.isEmpty() && dq.peek()<=i-k) {  // here is to pop out of window nums, it's not i, but it's i-k
                dq.poll();
            }
            int current = nums[i];
            while(!dq.isEmpty() && nums[dq.peekLast()]<current) {
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1) // as required by ps, start from k-1 location as result
                res[idx++] = nums[dq.peek()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,3,-1,-3,5,3,6,7};
        //printArray(new Q239().maxSlidingWindow(input, 3));
        printArray(new Q239().maxSlidingWindow(new int[0], 0));
    }
}
