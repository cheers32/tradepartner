package Q250_299;

import java.util.ArrayList;
import java.util.List;

public class Q264v2 {
    public int nthUglyNumber(int n) {  // N*3， 这个简化的版本，应该很满意了
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        while(list.size() < n) {  // this list stores only valid result, so check against required size
            int cand2 = list.get(idx2)*2;
            int cand3 = list.get(idx3)*3;
            int cand5 = list.get(idx5)*5;
            int min = Math.min(cand5, Math.min(cand2, cand3));
            if(min == cand2) {  // use all "if" to advance all qualified idx to avoid dups
                idx2++;
            }
            if(min == cand3) {
                idx3++;
            }
            if(min == cand5) {
                idx5++;
            }
            list.add(min);  // add result using min
        }
        return list.get(list.size()-1);  // return the last result
    }

    public static void main(String[] args) {
        System.out.println(new Q264v2().nthUglyNumber(1));
        System.out.println(new Q264v2().nthUglyNumber(2));
        System.out.println(new Q264v2().nthUglyNumber(3));
        System.out.println(new Q264v2().nthUglyNumber(4));
        System.out.println(new Q264v2().nthUglyNumber(5));
        System.out.println(new Q264v2().nthUglyNumber(6));
        System.out.println(new Q264v2().nthUglyNumber(7));
    }
}
