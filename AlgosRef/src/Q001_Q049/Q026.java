package Q001_Q049;

public class Q026 {
    public int removeDuplicates(int[] nums) { // n
        if(nums==null||nums.length==0)
            return 0;
        int start = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i]!=nums[start]) {
                start += 1;
                nums[start] = nums[i];
            }
        }
        return start+1;
    }
}
