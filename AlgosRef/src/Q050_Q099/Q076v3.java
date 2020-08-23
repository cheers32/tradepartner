package Q050_Q099;

public class Q076v3 {
    public String minWindow(String s, String t) {  // this is the best approach i can get, O(n)
        if(s==null || t==null)
            return "";
        int[] map = new int[128];
        for(char c : t.toCharArray())
            map[c]++;
        int start = 0;
        int bestStart = 0;
        int min = Integer.MAX_VALUE;
        int matchRem = t.length();  // use a remaining counter approach
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map[c]>0) {
                matchRem--;  // decrease rem only when above 0
            }
            map[c]--;  // always decrease map
            while(matchRem==0) {
                int len = i-start+1;
                if(len<min) {
                    min = len;
                    bestStart = start;
                }
                char startChar = s.charAt(start);
                map[startChar]++;  // increase map first
                if(map[startChar]>0)
                    matchRem++;
                start++;
            }
        }
        if(min==Integer.MAX_VALUE)
            return "";
        return s.substring(bestStart, bestStart+min);
    }

    public static void main(String[] args) {
        System.out.println(new Q076v2().minWindow("ADOBECODEBANC","ABC"));
        System.out.println(new Q076v3().minWindow("bba","ab"));
    }
}
