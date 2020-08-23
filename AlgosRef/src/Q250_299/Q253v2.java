package Q250_299;

import java.util.Arrays;

public class Q253v2 {
    public int minMeetingRooms(int[][] intervals) {  // NLogN, 这个改进方法针对start,end单独排序
        if(intervals==null)
            return 0;
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        int idx = 0;
        for(int[] item : intervals) {
            starts[idx] = item[0];
            ends[idx] = item[1];
            idx++;
        }
        Arrays.sort(starts);  // 这种单独排序的方法要学会用
        Arrays.sort(ends);

        int endIdx = 0;
        //int count = 0;
        int max = 0;
        for(int i=0; i<starts.length; i++) {  //
            if(starts[i]<ends[endIdx]) {  // corrected: 这一步是关键，我没有想出来，就是用当前的start和当前的end比较，从而递增max
                max++;
                //count++;
                //max = Math.max(max, count);  // 用count的方法看上去有些问题
            }
            else {
                endIdx++;  //这里开始没想对的是，当end++时，下一步start也++
                //count--;
            }
        }
        return max;
    }
}
