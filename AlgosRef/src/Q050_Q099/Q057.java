package Q050_Q099;

import java.util.ArrayList;
import java.util.List;

public class Q057 {  // this insert doesn't have to sort first, N
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null)
            return intervals;
        List<int[]> res = new ArrayList<>();
        boolean inserted = false;
        for(int[] i : intervals) {
            if(inserted || i[1] < newInterval[0]) {  // insert all separate case and before case
                res.add(i);
            } else if(i[0]>newInterval[1]) {  // insert after new interval case
                res.add(newInterval);
                res.add(i);
                inserted = true;
            } else if(i[1]>=newInterval[0] || i[0]<=newInterval[1]) { // update interval, condition is not necessary
                newInterval[0] = Math.min(newInterval[0], i[0]);
                newInterval[1] = Math.max(newInterval[1], i[1]);
            }
        }
        if (!inserted)  // last step to check whether it is inserted
            res.add(newInterval);
        int[][] resArr = new int[res.size()][];
        int idx = 0;
        for (int[] i : res)
            resArr[idx++] = i;
        return resArr;
    }

    public static void main(String[] args) {
        //int[][] input = new int[][] {{1,3},{6,9}};
        //int[][] input = new int[][] {};
        int[][] input = new int[][] {{2,5},{6,7},{8,9}};
        int[] newInt = new int[] {0, 1};
        int[][] res = new Q057().insert(input, newInt);
        System.out.println(res);
    }
}
