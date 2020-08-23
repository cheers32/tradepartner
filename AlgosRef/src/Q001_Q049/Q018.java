package Q001_Q049;

import java.util.*;

public class Q018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {  // n^3
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();  // this set is needed because a duplicate result is not avoidable
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1; j<nums.length; j++) {
                int s = j+1;
                int e = nums.length-1;
                while(s<e) {
                    int sum = nums[i]+nums[j]+nums[s]+nums[e];
                    if(sum==target) {
                        res.add(Arrays.asList(nums[i],nums[j],nums[s],nums[e]));
                        while(s<e && nums[s] == nums[s+1]) {
                            s++;
                        }
                        while(s<e && nums[e] == nums[e-1]) {
                            e--;
                        }
                        s++;
                        e--;
                    }
                    else if(sum<target)
                        s++;
                    else
                        e--;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        System.out.println(new Q018().fourSum(new int[] {-3,-2,-1,0,0,1,2,3}, 0));
    }
}
