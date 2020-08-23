package Q250_299;

import java.util.ArrayList;
import java.util.List;

public class Q254 { // 这个题是一个backtracking的经典题目，我已经画出了dfs树，顾虑是是否需要dp,以及是否需要去重; looks like a N^2 time, but in theory this is N!
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();  // 这个题就只有这一个brute force穷举法
        dfs(n, res, new ArrayList<>(), 2);
        return res;
    }

    void dfs(int n, List<List<Integer>> res, List<Integer> list, int start) {  // 多一个start，用于除重
        if(n<2) {
            if(list.size()>0)
                //res.add(list);  // corrected: must add a new list
                res.add(new ArrayList<>(list));
            return;
        }
        for(int i=start; i<=n; i++) {  // corrected: this must be <=n, so that it gets a 1 to next call, otherwise cannot get to base condition
            if(n%i==0) {
                list.add(i);  // backtracking也可在这里建一个新的list
                dfs(n/i, res, list, i);
                //list.remove(i);  // corrected: cannot remove number, must remove the last added item
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q254().getFactors(12));
    }
}
