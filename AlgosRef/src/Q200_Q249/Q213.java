package Q200_Q249;

public class Q213 {
    public int rob(int[] nums) { // N*2, first solution didn't pass single value case
        if(nums==null)
            return 0;
        if(nums.length==1)  // because for single value, only 1 is available, so just handle it differently
            return nums[0];
        int max = 0;
        int take = 0;
        int notTake = 0;
        for(int i=0; i<nums.length-1; i++) {
            int prevTake = take;
            take = Math.max(take, notTake+nums[i]);
            notTake = Math.max(notTake, prevTake);
            max = Math.max(max, Math.max(take, notTake));
        }
        take = 0;
        notTake = 0;
        for(int i=1; i<nums.length; i++) {
            int prevTake = take;
            take = Math.max(take, notTake+nums[i]);
            notTake = Math.max(notTake, prevTake);
            max = Math.max(max, Math.max(take, notTake));
        }
        return max;
    }

    public static void main(String[] args) {
        //int[] input = new int[] {2,3,2};
        int[] input = new int[] {1,2,3,1};
        System.out.println(new Q213().rob(input));
    }
}
