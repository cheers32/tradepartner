package Q001_Q049;

public class Q027 {
    public int removeElement(int[] nums, int val) { // n
        if(nums==null || nums.length==0)
            return 0;
        int start = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=val) {
                nums[start] = nums[i];
                start+=1;
            }
        }
        return start;
    }
}
