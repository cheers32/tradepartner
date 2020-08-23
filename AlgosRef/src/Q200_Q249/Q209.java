package Q200_Q249;

import java.util.HashMap;
import java.util.Map;

public class Q209 {
    public int minSubArrayLen(int s, int[] nums) {  // 这个题是一个简单版的滑动窗口题，Ｎ
        if (nums == null)
            return 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            while(sum>=s) {
                int len = i-start+1;
                minLen = Math.min(len, minLen);
                sum-=nums[start];
                start++;
            }
        }
        if(minLen == Integer.MAX_VALUE)
            return 0;
        return minLen;
    }

    public int minSubArrayLen_WrongProblem(int s, int[] nums) {  // 这个做法是==的解法，题目需要>=
        if(nums==null)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();  // rangeSum -> idx
        int rangeSum = 0;
        int minLen = Integer.MAX_VALUE;
        map.put(0, -1);
        for(int i=0; i<nums.length; i++) {
            rangeSum+=nums[i];
            int diff = rangeSum-s;
            if(map.containsKey(diff)) {
                int len = i-map.get(diff);
                minLen = Math.min(minLen, len);
            }
            map.put(rangeSum, i);  // map 里只进最靠后的index
        }
        if(minLen == Integer.MAX_VALUE)
            return 0;
        return minLen;
    }

    public static void main(String[] args) {
        int[] input = new int[] {2,3,1,2,4,3};
        System.out.println(new Q209().minSubArrayLen_WrongProblem(7, input));
        System.out.println(new Q209().minSubArrayLen_WrongProblem(15, input));
        input = new int[] {-2,4,2};
        System.out.println(new Q209().minSubArrayLen_WrongProblem(1, input));
        System.out.println(new Q209().minSubArrayLen_WrongProblem(1, input));
    }
}
