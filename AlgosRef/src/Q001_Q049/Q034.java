package Q001_Q049;

public class Q034 {
    public int[] searchRange(int[] nums, int target) {  // 2*logN
        int left = bs(nums, target-0.5);
        int right = bs(nums, target+0.5);
        if(left == right)
            return new int[]{-1,-1};
        else
            return new int[]{left, right-1};
    }

    int bs(int[] nums, double target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end) {  // always use <= in bs algo
            int mIdx = (start+end)/2;
            if(nums[mIdx]<target) {
                start = mIdx+1;
            }
            else
                end = mIdx-1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,7,7,8,8,10};
        System.out.println(new Q034().bs(input, 8));
        System.out.println(new Q034().bs(input, 7.5));
        System.out.println(new Q034().bs(input, 8.5));
        System.out.println(new Q034().bs(input, 4.5));
        System.out.println(new Q034().bs(input, 5.5));
        System.out.println(new Q034().bs(input, 6.5));
        System.out.println(new Q034().bs(input, 5.5));
    }
}
