package Q001_Q049;

import java.util.*;

public class Q047 {
    public List<List<Integer>> permuteUnique(int[] nums) { // n! time
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Set<List<Integer>> res = permute(nums, 0);
        return new ArrayList<>(res);
    }

    Set<List<Integer>> permute(int[] nums, int idx) {
        if(idx>=nums.length) {
            Set<List<Integer>> res = new HashSet<>();
            res.add(new ArrayList<>());
            return res;
        }
        int first = nums[idx];
        Set<List<Integer>> rest = permute(nums, idx+1);
        Set<List<Integer>> res = new HashSet<>();
        for(List<Integer> l : rest) {
            for(int i=0; i<=l.size(); i++) {
                List<Integer> newList = new ArrayList<>(l);
                newList.add(i, first);
                res.add(newList);  // use a set to directly add list type result without a need to check contains; maybe the combination sum can also use a set for dups
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,1,2};
        System.out.println(new Q047().permuteUnique(input));
//        Set<List<Integer>> set = new HashSet<>();
//        List<Integer> l1 =Arrays.asList(1,2,3);
//        List<Integer> l2 =Arrays.asList(1,2,3);
//        set.add(l1);
//        set.add(l2);
    }
}