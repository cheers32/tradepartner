package Q200_Q249;

public class Q238 {
    public int[] productExceptSelf(int[] nums) { // N, good solution, worked out on my own.
        if(nums==null)
            return new int[0];
        int[] dp = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            dp[i] = i==0? nums[i] : dp[i-1]*nums[i];  // even though this is ==0, next is i>0, but this is most intuitive
        }
        int product = 1;
        //int[] res = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--) {
            dp[i] = i>0 ? dp[i-1]*product:product;  // just write out some examples and will get it right
            product *= nums[i];
        }
        return dp;
    }
}
