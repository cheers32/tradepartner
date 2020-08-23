package Q150_Q199;

public class Q198 {
    public int rob(int[] nums) { // N, passed first time, 100%.
        if(nums==null)
            return 0;
        int take = 0;
        int notTake = 0;
        //int max = Integer.MIN_VALUE;  // this is not needed
        for(int n : nums) {
            int prevTake = take;   // both are ok, just make one as backup
            take = n + notTake;
            notTake = Math.max(prevTake, notTake);
            //int prevNotTake = notTake;  // this is important, make make a temp value because it will be used again
            //notTake = Math.max(notTake, take);
            //take = n+prevNotTake;
            //max = Math.max(max, Math.max(notTake, take));
        }
        return Math.max(take, notTake);
        //return max;
    }

    public int robJump2(int[] nums) {  // 这个解法是我的现场面试变形，要求至少隔两个
        if(nums==null)
            return 0;
        int take = 0;
        int notTake = 0;
        int notTake2 = 0;
        for(int n : nums) {
            int prevTake = take;   // both are ok, just make one as backup
            take = n + notTake2;
            notTake2 = notTake;
            notTake = Math.max(prevTake, notTake);
        }
        return Math.max(take, notTake);
        //return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q198().robJump2(new int[]{1,2,3,1}));
        System.out.println(new Q198().robJump2(new int[]{1,2,3,4}));
        //System.out.println(new Q198().rob(new int[]{1,2,-3,1}));
        //System.out.println(new Q198().rob(new int[]{-1,-2,-3,-1}));  // 这种情况的结果其实还是0, 因为是subset
    }
}
