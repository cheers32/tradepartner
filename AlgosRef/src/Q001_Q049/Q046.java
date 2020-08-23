package Q001_Q049;

import java.util.ArrayList;
import java.util.List;

public class Q046 {
    public List<List<Integer>> permute(int[] nums) { // n! time
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        res = permute(nums, 0);
        return res;
    }

    List<List<Integer>> permute(int[] nums, int idx) {
        if(idx>=nums.length) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        int first = nums[idx];
        List<List<Integer>> rest = permute(nums, idx+1);
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> l : rest) {
            for(int i=0; i<=l.size(); i++) {
                List<Integer> newList = new ArrayList<>(l);
                newList.add(i, first);
                res.add(newList);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,2,3};
        System.out.println(new Q046().permute(input));
    }
}