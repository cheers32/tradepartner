package Q001_Q049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {  // nlogn+n!
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);  // sort to eliminate quicker
        backTrack(candidates, target, res, new ArrayList<>(), candidates.length-1);
        return res;
    }

    void backTrack(int[] nums, int target, List<List<Integer>> res, List<Integer> path, int start) {
        if(target<0)
            return;
        if(target==0) {
            res.add(new ArrayList<>(path));  // create a new list only when adding to result
            return;
        }
        for(int i=start; i>=0; i--) {  // reduce from top index
            path.add(nums[start]);
            backTrack(nums, target-nums[start], res, path, start);
            path.remove(path.size()-1);
            start--;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] {2,3,6,7};
        List<List<Integer>> res = new Q039().combinationSum(input, 7);
        System.out.println(res );
    }
}
