package Q001_Q049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q039v2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {  // nlogn+n!
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length==0)
            return res;
        Arrays.sort(candidates);  // sort to eliminate quicker
        backTrack(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    void backTrack(int[] input, int target, List<List<Integer>> res, List<Integer> path, int start) {
        if(target<0)
            return;
        if(target==0) {
            res.add(new ArrayList<>(path));  // create a new list only when adding to result
            return;
        }
        for(int i=start; i<input.length; i++) {  // reduce from top index
            int cur = input[i];
            if(cur>target)  // this is to optimize
                break;
            path.add(cur);
            backTrack(input, target-cur, res, path, i);  // use i to advance
            path.remove(path.size()-1);
            //            List<Integer> newPath = new ArrayList<>(path);   // create a new list is not very good
            //            newPath.add(cur);
            //            backTrack(input, target-cur, res, newPath, i);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] {2,3,6,7};
        List<List<Integer>> res = new Q039v2().combinationSum(input, 7);
        System.out.println(res );
    }
}
