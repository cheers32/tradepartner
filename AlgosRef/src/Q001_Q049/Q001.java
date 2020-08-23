package Q001_Q049;

import java.util.HashMap;
import java.util.Map;

public class Q001 {
    public int[] twoSum(int[] nums, int target) {  // n
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();  // num, idx
        // one loop to check if num and target-num is in map
        for(int i=0; i<nums.length; i++) {
            int cand = target-nums[i];
            if(map.containsKey(cand) && map.get(cand) != i) {
                res[0]=i;
                res[1]=map.get(cand);
            }
            else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
