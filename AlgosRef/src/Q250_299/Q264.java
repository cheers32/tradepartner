package Q250_299;

import java.util.ArrayList;
import java.util.List;

public class Q264 {
    public int nthUglyNumber(int n) {  // this is a very good solution, N*3, using 3 idx, compare 3 results every round and add
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        //for(int i=0; i<n-1; i++) {  // the first is 1, not 2, so num of runs changed to n-1 rather than n
        while(list.size() < n) { // corrected: this condition is not correct, it must use the result size rather than times of operations because dups exist
            int cand2 = list.get(idx2)*2;
            int cand3 = list.get(idx3)*3;
            int cand5 = list.get(idx5)*5;
            int min = Math.min(cand5, Math.min(cand2, cand3));
            if(min == cand2) {
                if(cand2 != list.get(list.size()-1))  // corrected: must be non-dup values to add
                    list.add(cand2);
                idx2++;
                //idx2 = list.size()-1;  // corrected: it's not move the end, but just move 1 index
            } else if(min == cand3) {
                if(cand3 != list.get(list.size()-1))
                    list.add(cand3);
                idx3++;
                //idx3 = list.size()-1;
            } else if(min == cand5) {
                if(cand5 != list.get(list.size()-1))
                    list.add(cand5);
                idx5++;
                //idx5 = list.size()-1;
            }
        }
        return list.get(list.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(new Q264().nthUglyNumber(1));
        System.out.println(new Q264().nthUglyNumber(2));
        System.out.println(new Q264().nthUglyNumber(3));
        System.out.println(new Q264().nthUglyNumber(4));
        System.out.println(new Q264().nthUglyNumber(5));
        System.out.println(new Q264().nthUglyNumber(6));
        System.out.println(new Q264().nthUglyNumber(7));
    }
}
