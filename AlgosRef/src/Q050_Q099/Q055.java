package Q050_Q099;

public class Q055 {
    public boolean canJump(int[] nums) {  // n, my approach is more intuitive; is there any more improvement? the speed will still be N; this is not a dp problem
        if(nums==null || nums.length==0)
            return false;
        int remaining = 0;  // the key is to get whether the remaining steps are ok
        for(int i=0; i< nums.length; i++) {
            if(i == nums.length-1)
                return true;
            remaining -= 1;
            remaining = Math.max(remaining, nums[i]);
            if(remaining <= 0)  // this must be <=, so that to launch next jump
                return false;
        }
        return true;
    }

//    public boolean canJump(int[] nums) {  // not working, greedy
//        int right = 0;
//        for(int i=0; i< nums.length; i++) {
//            int reach = i+nums[i];
//            if(reach>=right) {
//                if(i>right)
//                    right = i;
//            }
//        }
//        return right==nums.length-1;
//    }

    public static void main(String[] args) {
        int[] input = new int[]{2,5,0,1,4};
        System.out.println(new Q055().canJump(input));
        input = new int[]{3,2,1,0,4};
        System.out.println(new Q055().canJump(input));
    }
}
