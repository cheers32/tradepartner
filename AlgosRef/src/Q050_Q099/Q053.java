package Q050_Q099;

public class Q053 {
    public int maxSubArray(int[] nums) {  // n
        if(nums==null || nums.length==0)
            return 0;
        int sum = nums[0]; // only need to change to 0 if 0 is default
        int max = sum;
        for(int i=1; i<nums.length; i++) {
            sum = Math.max(nums[i], sum+nums[i]);  // each running sum is determined by taking current only or together with sum
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        //int[] input = new int[]{1,-3,5};
        int[] input = new int[]{-1,-3,-5};
        System.out.println(new Q053().maxSubArray(input));
    }
}
