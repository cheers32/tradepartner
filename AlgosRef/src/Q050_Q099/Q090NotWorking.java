package Q050_Q099;

import java.util.ArrayList;
import java.util.List;

public class Q090NotWorking {
    public List<List<Integer>> subsetWithDup(int[] nums) {
        if(nums == null || nums.length==0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++) {
            int cur = nums[i];
            int size = res.size();
            for(int j=0; j<size; j++) {
                List<Integer> newList = new ArrayList<>(res.get(j));
                newList.add(cur);
                res.add(newList);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,2};
        List<List<Integer>> res = new Q090NotWorking().subsetWithDup(nums);
        System.out.println(res);
    }
}
