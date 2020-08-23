package Q050_Q099;

public class Q075 {
    public void sortColors(int[] nums) {
        int p1 = 0;
        int p2 = nums.length-1;
        int idx = 0;
        while(idx<=p2) {
            int cur = nums[idx];
            if(cur == 0) {
                nums[idx] = nums[p1];
                nums[p1] = 0;
                p1++;
                idx++;
            } else if(cur == 1) {
                idx++;
            } else if(cur == 2) {
                nums[idx] = nums[p2];
                nums[p2] = 2;
                p2--;  // no idx advance, because it could be 0 and needs to swap again with p1
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {2,1,1,0,0,2};
        new Q075().sortColors(input);
        System.out.println(input);
    }
}
