package Q100_Q149;

import ds.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Q118 {
    public List<List<Integer>> generate(int numRows) {  // wrote and passed first time; easy; N^2
        List<List<Integer>> res = new ArrayList<>();
        if(numRows<=0)
            return res;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(new ArrayList<>(list)); // this way is to create a new list when adding to list, can make it easy to main the current list
        if(numRows==1)
            return res;
        list.add(1);
        res.add(new ArrayList<>(list));
        if(numRows==2)
            return res;
        numRows-=2;
        while(numRows>0) {
            List<Integer> l = new ArrayList<>(list);
            List<Integer> prev = res.get(res.size()-1);  // get last one
            for(int i=0; i<prev.size()-1; i++)
                l.add(l.size()-1, prev.get(i)+prev.get(i+1)); // add to 2nd to last loc
            res.add(l);
            numRows--;  // dont' forget to decrease
        }
        return res;
    }
}
