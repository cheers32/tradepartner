package Q200_Q249;

import java.util.HashMap;
import java.util.Map;

public class Q209v2 {
    public int minSubArrayLen(int s, int[] nums) {  // 这个题的另一个变形是要求用range sum做，也就是把N^2的做法优化成NlogN, 这种做法适用于各种N2时间的优化，比较重要
        if (nums == null)
            return 0;
        int minLen = Integer.MAX_VALUE;
        int[] rangeSum = new int[nums.length+1];
        for(int i=0; i<nums.length; i++) {
            rangeSum[i+1] = nums[i] + rangeSum[i];  // sum before this num at i
        }
        for(int i=0; i<rangeSum.length; i++) {
            int start = i;
            int end = rangeSum.length-1;
            while(start<=end) {
                int midIdx = (start+end)/2;
                int midVal = rangeSum[midIdx];
                int target = rangeSum[i]+s;  // this is like two sum diff
                if(midVal<target) {  // here should be s+rangeSum[i], not very sure
                    start=midIdx+1;
                } else if(midVal>=target) {  // 不过问题在于这里很难调整，不知道如何得到正确答案
                    end = midIdx-1;
                }
            }
            int len = end-start+1;
            minLen = Math.min(len, minLen);
        }
        return minLen;
    }



    public static void main(String[] args) {
        int[] input = new int[] {2,3,1,2,4,3};
        System.out.println(new Q209v2().minSubArrayLen(7, input));
    }
}
