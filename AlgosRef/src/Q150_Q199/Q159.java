package Q150_Q199;

import java.util.HashMap;
import java.util.Map;

public class Q159 {  // 2*N*k, this is my standard approach using counting
    public int lengthOfLongestSubstringTwoDistinct(String s) {  // int[] count = new int[256]; this may be faster than map
        if(s==null || s.length()==0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
            while(map.keySet().size()>2) {
                char startChar = s.charAt(start);
                if(map.get(startChar)==1)
                    map.remove(startChar);
                else
                    map.put(startChar, map.get(startChar)-1);
                start++;
            }
            int len = i-start+1;
            max = Math.max(max, len);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q159().lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
