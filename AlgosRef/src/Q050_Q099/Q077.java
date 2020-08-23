package Q050_Q099;

import java.util.ArrayList;
import java.util.List;

public class Q077 {
    public List<List<Integer>> combine(int n, int k) {  // n^k, this is a good solution
        List<List<Integer>> res = new ArrayList<>();
        combine(res, 1, n, new ArrayList<>(), k);
        return res;
    }

    void combine(List<List<Integer>> res, int start, int n, List<Integer> cur, int count) {
        if(count == 0) {  // base condition
            //res.add(cur);
            res.add(new ArrayList<>(cur));  // only create a new list when adding to final result
            return;
        }
        for(int i=start; i<=n; i++) {
            //List<Integer> newList = new ArrayList<>(cur);
            //newList.add(i);
            //combine(res, i+1, n, newList, count-1);
            cur.add(i);
            combine(res, i+1, n, cur, count-1);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Q077().combine(4, 2);
        System.out.println(res);

    }
}
