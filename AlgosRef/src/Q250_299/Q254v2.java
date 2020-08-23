package Q250_299;

import java.util.ArrayList;
import java.util.List;

public class Q254v2 { // 没有一个例子说明这个可以用dp来变快，一个原因是因为要到最底层才加入结果，而不是依赖返回值
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, res, new ArrayList<>(), 2);
        return res;
    }

    void dfs(int n, List<List<Integer>> res, List<Integer> list, int start) {
        if(n<2) {  // 这两个条件可以放到一起
            if(list.size()>0)
                res.add(list);
            return;
        }
        for(int i=start; i<=n; i++) {
            if(n%i==0) {
                List<Integer> newList = new ArrayList<>(list);  // 在这里新建一个list，时间上是一样的，省了revert的那一步
                newList.add(i);
                dfs(n/i, res, newList, i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q254v2().getFactors(12));
    }
}
