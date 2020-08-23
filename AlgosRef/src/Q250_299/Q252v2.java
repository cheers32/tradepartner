package Q250_299;

import java.util.*;

public class Q252v2 {
    public boolean canAttendMeetings(int[][] intervals) {  // this is map approach, also sorted by key, NLogN; not as good as v1
        if(intervals==null)
            return false;
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
        for(Integer time : keys) {
            count += map.get(time);
            if(count>1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q252v2().canAttendMeetings(new int[][]{{13,15},{1,13}}));
    }
}
