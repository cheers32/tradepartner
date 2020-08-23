package Q100_Q149;

import ds.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q120 {
    public int minimumTotal(List<List<Integer>> triangle) {  // N, passed at the first time, but it's slow solution; also made a few mistakes
        if(triangle==null)  // 网上的做法是从最后一行开始算
            return 0;
        //int min = Integer.MAX_VALUE;
        List<Integer> lastRow = null;
        for(List<Integer> list : triangle) {
            if(lastRow == null) {  // 第一行初始化
                lastRow = list;
                continue;
            }
            List<Integer> newRow = new ArrayList<>();
            for(int i=0; i<list.size(); i++) {
                int last1 = i>0?lastRow.get(i-1):10000;  // here the max value caused overflow, shouldn't be
                int last2 = i<lastRow.size()?lastRow.get(i):10000;
                int curMin = Math.min(list.get(i)+last1, list.get(i)+last2);
                //min = Math.min(curMin, min);  //只应在最后一行比较
                newRow.add(curMin);
//                if(i<lastRow.size())    // should use a new list instead of update in-place, because it makes subsequent addition wrong, 要注意in-place的问题
//                    lastRow.set(i, curMin);
//                else
//                    lastRow.add(curMin);
            }
            lastRow = newRow;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<lastRow.size(); i++)
            min = Math.min(min, lastRow.get(i));
        return min;
    }

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(2);
        List<Integer> l2 = Arrays.asList(3,4);
        List<Integer> l3 = Arrays.asList(6,5,7);
        List<Integer> l4 = Arrays.asList(4,1,8,3);
        List<List<Integer>> input = new ArrayList<>();
        input.add(l1);input.add(l2);input.add(l3);input.add(l4);
        System.out.println(new Q120().minimumTotal(input));
    }
}
