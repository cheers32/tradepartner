package Q001_Q049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length==0)
            return res;
        Arrays.sort(candidates);
        backTrack(candidates, res, target, new ArrayList<>(), 0);
        return res;
    }

    void backTrack(int[] input, List<List<Integer>> res, int target, List<Integer> path, int start) {
        if(target<0)
            return;
        if(target==0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start; i<input.length; i++) {
            int cur = input[i];
            if(i!=start && cur==input[i-1])  // skip on same sub-state
                continue;
            if(cur>target)
                break;
            path.add(cur);
            backTrack(input, res, target-cur, path, i+1); // this must pass in i+1, not start+1
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] {10,1,2,7,6,1,5};
        List<List<Integer>> res = new Q040().combinationSum2(input, 8);
        System.out.println(res);
    }
}
