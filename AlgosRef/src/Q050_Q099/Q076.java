package Q050_Q099;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Q076 {
    public String minWindow(String s, String t) {  // n*m
        if(s==null || t==null)
            return "";

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        int min = Integer.MAX_VALUE;  // cannot assume max is the len(s), because it is not matching
        int start = 0;
        int bestStart = 0;  // must have a best start, so that no need to get best string every time
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c))
                map.put(c, map.get(c)-1);  // must be clear about the key, not i
            while(isAllClear(map)) {
                int len = i-start+1;
                if(len < min) {
                    bestStart = start;
                    min = len;
                }
                char startChar = s.charAt(start);
                if(map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                }
                start++;
            }
        }
        if(min == Integer.MAX_VALUE)  // must check not found condition, and return empty
            return "";
        return s.substring(bestStart, bestStart+min); // note the correct way to use substring
    }

    boolean isAllClear(Map<Character, Integer> map) {
        for(char c : map.keySet()) {
            if(map.get(c)>0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q076().minWindow("ADOBECODEBANC","ABC"));
    }
}
