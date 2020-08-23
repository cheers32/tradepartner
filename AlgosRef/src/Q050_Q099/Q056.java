package Q050_Q099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q056 {
    public int[][] merge(int[][] intervals) {  // very good, pass at first time, N time
        if (intervals == null || intervals.length == 0)
            return intervals;
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);  // sort syntax to remember
        List<int[]> res = new ArrayList<>();
        for (int[] i : intervals) {
            if (res.size() == 0) {  // init case with first interval
                res.add(i);
            } else {
                int[] last = res.get(res.size() - 1);
                if (i[0] > last[1])  // only 2 cases to discuss, extend, or separate, the eat-in case is skipped
                    res.add(i);
                else if (i[1] > last[1])
                    last[1] = i[1];
            }
        }
        int[][] resArr = new int[res.size()][];
        int idx = 0;
        for (int[] i : res)
            resArr[idx++] = i;
        return resArr;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = new Q056().merge(input);
        System.out.println(res);
    }
}
