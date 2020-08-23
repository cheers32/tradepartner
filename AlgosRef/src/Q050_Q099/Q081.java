package Q050_Q099;

public class Q081 {
    public boolean search(int[] nums, int target) {  // logN
        if(nums==null || nums.length==0)
            return false;
        int left = 0;
        int right = nums.length-1;
        while(left<=right) {
            int mIdx = (left+right)/2;
            if(nums[mIdx]==target)
                return true;
            if(nums[left]<nums[mIdx]) { // left is ordered
                if(nums[left]<=target && target<=nums[mIdx]) {  // must be 2 checks
                    right = mIdx-1;
                }
                else {
                    left = mIdx+1;
                }
            } else if(nums[left] > nums[mIdx]) { // right is ordered, both are using left comparing to mIdx
                if(nums[mIdx]<=target && target <= nums[right]) {
                    left = mIdx+1;
                }
                else {
                    right = mIdx-1;
                }
            } else {  // this condition is tricky, only advancing left
                left++;
            }
        }
        return false;
    }
}
