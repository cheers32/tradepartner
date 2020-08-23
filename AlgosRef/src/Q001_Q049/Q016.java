package Q001_Q049;

import java.util.Arrays;

public class Q016 {
    public int threeSumclosest(int[] nums, int target) {  //n^2
        if(nums==null || nums.length<3) // we can assume nums len is greater than 2 to skip this
            return 0;
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[2];
        for(int i=0; i<nums.length-2; i++) {
            int s = i+1;
            int e = nums.length-1;
            while(s<e) {
                int sum = nums[s]+nums[e]+nums[i];
                if(sum==target) // can directly return for equal
                    return sum;
                if(Math.abs(sum-target)<Math.abs(res-target))
                    res = sum;
                if(sum<target)  // must check result to advance
                    s++;
                else
                    e--;  // minor error, this was e++ and wrong
            }
        }
        return res;
    }

}
