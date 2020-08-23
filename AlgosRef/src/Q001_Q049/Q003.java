package Q001_Q049;

import java.util.HashMap;
import java.util.Map;

public class Q003 {
    public int lengthOfLongestSubstring(String s) {  // n
        Map<Character, Integer> map = new HashMap<>(); // char, cnt   use a map to move index quicker
        int res = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                start = Math.max(start, map.get(c)+1);  // this is needed because new start may not be greater than current start
            }
            map.put(c, i);
            int len = i-start+1;
            res = len>res ? len : res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q003().lengthOfLongestSubstring("abcazz"));
        System.out.println(new Q003().lengthOfLongestSubstring("abba"));
    }
}
