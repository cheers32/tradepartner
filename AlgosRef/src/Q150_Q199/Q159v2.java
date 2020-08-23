package Q150_Q199;

import java.util.HashMap;
import java.util.Map;

public class Q159v2 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {  // 2*N*k, this approach uses the last seen index
        if(s==null || s.length()==0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
                map.put(c, i);
            while(map.keySet().size()>2) {
                int leftIdx = s.length()-1;
                for(int v : map.values()) {
                    leftIdx = Math.min(v, leftIdx);
                }
                char leftChar = s.charAt(leftIdx);
                map.remove(leftChar);
                start = leftIdx+1;  // mistake, not leftChar
            }
            int len = i-start+1;
            max = Math.max(max, len);
        }
        return max;
    }

    public static void main(String[] args) {
        //System.out.println(new Q159v2().lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(new Q159v2().lengthOfLongestSubstringTwoDistinct("bacc"));
    }
}
