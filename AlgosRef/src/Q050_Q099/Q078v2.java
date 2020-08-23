package Q050_Q099;

import java.util.ArrayList;
import java.util.List;

public class Q078v2 {  // n!  this recursion is not very fast; there is another counting approach, not done yet
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        find(res, nums, 0, new ArrayList<>());
        return res;
    }

    void find(List<List<Integer>> res, int[] nums, int start, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for(int i=start; i<nums.length; i++) {
            list.add(nums[i]);  // don't use wrong idx
            find(res, nums, i+1, list);  // don't use wrong idx
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,2,3};
        List<List<Integer>> res = new Q078v2().subsets(input);
        System.out.println(res);
    }
}
