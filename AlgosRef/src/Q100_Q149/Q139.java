package Q100_Q149;

import java.util.*;

public class Q139 {
    public Boolean wordBreak(String s, List<String> wordDict) {  // N^2 solution, easy variation from 140
        if(s==null || wordDict==null)
            return true;
        Map<Integer, Boolean> idxMap = new HashMap<>(); // idx -> words list found
        return find(s, 0, idxMap, new HashSet<>(wordDict));
    }

    Boolean find(String s, int start, Map<Integer, Boolean> idxMap, Set<String> dict) {
        if(start>s.length()-1) {
            return true;
        }
        if(idxMap.containsKey(start))
            return idxMap.get(start);
        Boolean res = false;
        for(int i=start+1; i<=s.length(); i++) {
            String str = s.substring(start, i);
            if(dict.contains(str)) {
                if(find(s, i, idxMap, dict)) {
                    res = true;
                    break;
                }
            }
        }
        idxMap.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("cat");dict.add("cats");dict.add("and");dict.add("sand");dict.add("dog");
        System.out.println(new Q139().wordBreak("catsanddog",dict));
    }
}
