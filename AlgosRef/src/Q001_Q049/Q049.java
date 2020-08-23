package Q001_Q049;

import java.util.*;

public class Q049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String key = new String(sArray);
            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        for(String k : map.keySet()) {
            res.add(map.get(k));
        }
        return res;
    }

    public static void main(String[] args) {
        String[] input = new String[] {"tea"};
        new Q049().groupAnagrams(input);
    }
}
