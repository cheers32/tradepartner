package Q001_Q049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q015 {
    public List<List<Integer>> threeSum(int[] nums) { // n^2 time
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<3)  // not necessary
            return res;
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            if(i>0 && nums[i] == nums[i-1]) // move to next different location
                continue;
            int s = i+1;
            int e = nums.length-1;
            int target = 0 - nums[i];
            while(s<e) {
                if(nums[s]+nums[e]==target) {
                    res.add(Arrays.asList(nums[i], nums[s], nums[e]));
                    while(s<e && nums[s]==nums[s+1]) // move to last duplicate location
                        s++;
                    while(s<e && nums[e]==nums[e-1])
                        e--;
                    s++;  // forgot this advance at first time
                    e--;
                }
                else if (nums[s]+nums[e]<target)
                    s++;
                else
                    e--;
            }


        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q015().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
