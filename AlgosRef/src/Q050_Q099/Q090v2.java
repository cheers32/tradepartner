package Q050_Q099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q090v2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {  // this is the standard N*2^n solution, using count
        if(nums == null || nums.length==0)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<=nums.length; i++) {  // this has to be <=
            build(res, nums, new ArrayList<>(), i, 0);
        }
        return res;
    }

    void build(List<List<Integer>> res, int[] nums, List<Integer> list, int count, int start) {
        if(count==0) {
            res.add(new ArrayList<>(list));  // notice to add a new list
            return;
        }
        for(int i=start; i<nums.length; i++) {
            if(i>start && nums[i]==nums[i-1])
                continue;
            list.add(nums[i]);
            build(res, nums, list, count-1, i+1); // always made this mistake
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,2};
        List<List<Integer>> res = new Q090v2().subsetsWithDup(nums);
        System.out.println(res);
    }
}
