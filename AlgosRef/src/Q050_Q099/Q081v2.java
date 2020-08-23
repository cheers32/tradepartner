package Q050_Q099;

public class Q081v2 {
    public boolean search(int[] nums, int target) {  // this is not a binary search, it's just a normal search, N
        if (nums == null || nums.length == 0)
            return false;
        return search(nums, target, 0, nums.length - 1);
    }

    boolean search(int[] nums, int target, int left, int right) {
        if(left>right)
            return false;
        int mIdx = (left+right)/2;
        if(nums[mIdx]==target)
            return true;
        boolean leftRes = search(nums, target, left, mIdx-1);
        boolean rightRes = search(nums, target, mIdx+1, right);

        return leftRes || rightRes;
    }
}
