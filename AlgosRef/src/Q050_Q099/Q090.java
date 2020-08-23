package Q050_Q099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {  // N*2^N, every digit to include or not, n possible count (details as in v2)
        if(nums == null || nums.length==0)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        build(res, nums, new ArrayList<>(), 0);
        return res;
    }

    void build(List<List<Integer>> res, int[] nums, List<Integer> cur, int start) {
        //if(start>nums.length)  // this must not be >=, but should be >, because still need to add the last list, not necessary
        //    return;
        res.add(new ArrayList<>(cur)); // must create a new list
        for(int i=start; i<nums.length; i++) {
            if(i>start && nums[i]==nums[i-1])  // this is the key, i>start, not i>0
                continue;
            cur.add(nums[i]);
            build(res, nums, cur, i+1);  // this should be i+1
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,2};
        List<List<Integer>> res = new Q090().subsetsWithDup(nums);
        System.out.println(res);
    }
}
