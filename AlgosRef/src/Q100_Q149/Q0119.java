package Q100_Q149;

import ds.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0119 {
    public List<Integer> getRow(int rowIndex) {   // this is trivial follow up from q118, easy solution, N^2
        List<Integer> res = new ArrayList<>();
        while(rowIndex>=0) {
            res.add(0, 1);
            for(int i=1; i<res.size()-1; i++) {
                res.set(i, res.get(i)+res.get(i+1));
            }
            rowIndex--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q0119().getRow(0));
        System.out.println(new Q0119().getRow(1));
        System.out.println(new Q0119().getRow(2));
        System.out.println(new Q0119().getRow(3));
        System.out.println(new Q0119().getRow(4));
    }
}
