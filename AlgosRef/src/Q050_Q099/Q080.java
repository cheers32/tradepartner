package Q050_Q099;

public class Q080 {
    public int removeDuplicates(int[] nums) {  // N, this ongoing assignment approach is very good
        int idx=0;
        for(int x : nums) {
            if(idx<2 || x>nums[idx-2]) {
                nums[idx] = x;
                idx++;
            }
        }
        return idx;
    }
}
