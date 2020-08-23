package Q400_Q449;

import java.util.HashSet;
import java.util.Set;

public class Q409 {  // 这题可用一个map计数，但改进方法是用一个set，每获得两个就计2，这样最后不用专门统计
    public int longestPalindrome(String s) {
        if(s==null)
            return 0;
        Set<Character> set = new HashSet<>();
        int res = 0;
        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                res += 2;
                set.remove(c);
            }
            else
                set.add(c);
        }
        if(set.size()>0)
            res+=1;
        return res;
    }
}
