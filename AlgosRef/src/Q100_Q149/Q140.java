package Q100_Q149;

import java.util.*;

public class Q140 {
    public List<String> wordBreak(String s, List<String> wordDict) {  // N^3 solution; this is recursion with memoization
        if(s==null || wordDict==null)
            return new ArrayList<>();
        Map<Integer, List<String>> idxMap = new HashMap<>(); // idx -> words list found
        return find(s, 0, idxMap, new HashSet<>(wordDict));
    }

    List<String> find(String s, int start, Map<Integer, List<String>> idxMap, Set<String> dict) {
        if(start>s.length()-1) {
            List<String> res = new ArrayList<>();
            res.add("");  // found out this empty string is needed
            return res;
        }
        if(idxMap.containsKey(start))
            return idxMap.get(start);
        List<String> res = new ArrayList<>();
        for(int i=start+1; i<=s.length(); i++) { // found out start+1 and <= during debug because of substring
            String str = s.substring(start, i);
            if(dict.contains(str)) {
                //List<String> cur = new ArrayList<>();  // found out only the res is needed
                List<String> rest = find(s, i, idxMap, dict);
                for(String sTmp : rest) {
                    if(sTmp.equals(""))
                        res.add(str);
                    else
                        res.add(str+" "+sTmp);
                }
                //idxMap.put(i, cur);
                //res.addAll(cur);
            }
        }
        idxMap.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("cat");dict.add("cats");dict.add("and");dict.add("sand");dict.add("dog");
        System.out.println(new Q140().wordBreak("catsanddog",dict));
    }
}
