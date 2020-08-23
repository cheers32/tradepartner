package Q200_Q249;

import java.util.HashMap;
import java.util.Map;

public class Q242 {
    public boolean isAnagram(String s, String t) {  // O(len(s)), good solution, i just added one length equals condition, so that it can be solve by just one pass
        if(s==null || t==null || s.length()!=t.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(!map.containsKey(c))
                map.put(c, 1);
            else
                map.put(c, map.get(c)+1);
        }
        for(char c : t.toCharArray()) {
            if(map.containsKey(c)) {  // it can also be solved by adding a condition here, map.get(c)>0 besides containsKey, and it can return false early
                map.put(c, map.get(c)-1);
            }
        }
        for(char key : map.keySet()) {
            if(map.get(key)>0)
                return false;
        }
        return true;
    }
}
