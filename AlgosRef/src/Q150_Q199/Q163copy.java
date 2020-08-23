package Q150_Q199;

import java.util.ArrayList;
import java.util.List;

public class Q163copy {  // N, 这个题我是抄的网上的做法,但基本思路就是把所有元素都走一遍,重点在于很多corner case,主要是得按照要求表示出来
    public List<String> findMissingRange(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int n : nums) {
            if(n==Integer.MIN_VALUE) {
                lower = n+1;
                continue;
            }
            if(lower == n-1)
                res.add("" + lower);
            else if(n-1 > lower)
                res.add(lower+"->"+(n-1));
            if(n==Integer.MAX_VALUE)
                return res;
            lower = n+1;
        }
        if(lower==upper)
            res.add(""+lower);
        else if(lower<upper)
            res.add(lower+"->"+upper);
        return res;
    }
}
