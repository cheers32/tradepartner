package Q100_Q149;

import ds.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q118v2 {
    public List<List<Integer>> generate(int numRows) {  // this is a better solution, using the addition concept; N^2
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        while(numRows>0) {
            row.add(0, 1);
            for(int i=1; i<row.size()-1; i++) {
                row.set(i, row.get(i)+row.get(i+1));
            }
            numRows--;
            res.add(new ArrayList<>(row));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q118v2().generate(4));
    }
}
