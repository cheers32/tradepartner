package Q100_Q149;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q120imprv {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null)
            return 0;
        List<Integer> lastRow = null;
        for(List<Integer> list : triangle) {
            if(lastRow == null) {
                lastRow = list;
                continue;
            }
            List<Integer> newRow = new ArrayList<>();
            for(int i=0; i<list.size(); i++) {
                int curMin = 0;
                if(i==0) {
                    curMin = list.get(i)+lastRow.get(i);
                }
                else if(i==lastRow.size()) {
                    curMin = list.get(i)+lastRow.get(i-1);
                }
                else {
                    curMin = list.get(i)+Math.min(lastRow.get(i-1),lastRow.get(i));
                }
                newRow.add(curMin);
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
        System.out.println(new Q120imprv().minimumTotal(input));
    }
}
