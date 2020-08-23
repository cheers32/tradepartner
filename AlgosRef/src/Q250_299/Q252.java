package Q250_299;

import java.util.Arrays;

public class Q252 {
    public boolean canAttendMeetings(int[][] intervals) {  // NLogN, this approach doesn't need space, but slow, it's not slow, this is the standard approach
        if(intervals==null)
            return false;
        int prevEnd = 0;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        for(int[] item : intervals) {
            if(item[0]<prevEnd)
                return false;
            prevEnd = item[1];
        }
        return true;
    }

    public boolean canAttendMeetings2(int[][] intervals) {  // NLogN, improved on online judge speed
        if(intervals==null)
            return false;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        for(int i=1; i<intervals.length; i++) {  // this one uses index based, speed is faster in online judge; one single meeting or no meeting means true
            if(intervals[i][0]<intervals[i-1][1])
                return false;
        }
        return true;
    }
}
