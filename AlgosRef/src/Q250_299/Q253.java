package Q250_299;

import java.util.*;

public class Q253 {
    public int minMeetingRooms(int[][] intervals) {  // NLogN, but this solution seems not very fast； 其实我更喜欢我的这个map的方法
        if(intervals==null)
            return 0;
        Map<Integer, Integer> map = new HashMap<>(); // time, count
        for(int[] item : intervals) {
            if(!map.containsKey(item[0]))
                map.put(item[0], 1);
            else
                map.put(item[0],map.get(item[0])+1);
            if(!map.containsKey(item[1]))
                map.put(item[1], -1);
            else
                map.put(item[1],map.get(item[1])-1);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());  // set cannot be sorted
        Collections.sort(keys);
        int count = 0;
        int max = 0;
        for(Integer time : keys) {
            count += map.get(time);
            max = Math.max(max, count);
        }
        return max;
    }
}
