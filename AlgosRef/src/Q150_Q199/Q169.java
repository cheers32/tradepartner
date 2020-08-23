package Q150_Q199;

public class Q169 {  // N, this should be a greedy solution; this is a voting algorithm, name is boyer-moting
    public int majorityElement(int[] nums) { // very good solution, the name is called
        if(nums==null || nums.length==0)
            return -1;
        int cand = nums[0];
        int count = 0;
        for(int n : nums) {
            if(n==cand)
                count++;
            else {
                count--;
                if(count==0) {
                    cand = n;
                    count = 1;
                }
            }
        }
        count = 0;
        for(int n : nums) {
            if(n==cand)
                count++;
        }
        if(count>nums.length/2)
            return cand;
        return -1;
    }
}
