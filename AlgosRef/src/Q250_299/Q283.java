package Q250_299;

public class Q283 {
    public void moveZeroes(int[] nums) {
        if(nums == null)
            return;
        int nonZeroIdx = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=0) {
                nonZeroIdx++;
                continue;
            }
            if(nonZeroIdx)
            while(nonZeroIdx<nums.length) {
                if(nums[nonZeroIdx]!=0)
                    break;
                nonZeroIdx++;
            }
            nums[i] = nums[nonZeroIdx];
            nums[nonZeroIdx] = 0;
            nonZeroIdx++;
        }
    }
}
