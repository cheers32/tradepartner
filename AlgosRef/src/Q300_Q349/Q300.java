package Q300_Q349;

import java.util.Arrays;

public class Q300 {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j]<nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}
