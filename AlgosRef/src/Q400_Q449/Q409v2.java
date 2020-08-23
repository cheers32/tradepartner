package Q400_Q449;

import java.util.HashSet;
import java.util.Set;

public class Q409v2 {  // 这个做法直接使用int[128],同时每次判断整数，且用res%2来判断是否需要做最后的+1
    public int longestPalindrome(String s) {
        if(s==null)
            return 0;
        int[] bucket = new int[128];
        for(char c : s.toCharArray()) {
            bucket[c]++;
        }
        int res = 0;
        for(int i : bucket) {
            res += i/2*2;
            if(res%2==0 && i%2==1)
                res+=1;
        }
        return res;
    }
}
