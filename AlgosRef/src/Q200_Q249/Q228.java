package Q200_Q249;

import java.util.ArrayList;
import java.util.List;

public class Q228 {
    public List<String> summaryRanges(int[] nums) { // N, passed after 1 fix; 两步走，先获得interval, 再translate成Ouput格式
        if(nums==null)
            return new ArrayList<>();
        List<int[]> intervals = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            int val = nums[i];
            if(intervals.isEmpty() || intervals.get(intervals.size()-1)[1]!=val-1) {  // here was the fix: shouldn't use i to access interval, should use interval.size(), no need to check i>0
                intervals.add(new int[]{val, val});
            } else {
                intervals.get(intervals.size()-1)[1] = val;  // same here
            }
        }
        List<String> res = new ArrayList<>();
        for(int[] item : intervals) {
            if(item[0]==item[1])
                res.add(String.valueOf(item[0]));
            else
                res.add(String.valueOf(item[0])+"->"+ String.valueOf(item[1]));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q228().summaryRanges(new int[] {0,1,2,4,5,7}));
    }
}
