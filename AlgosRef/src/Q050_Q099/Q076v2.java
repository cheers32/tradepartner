package Q050_Q099;

import java.util.HashMap;
import java.util.Map;

public class Q076v2 {
    public String minWindow(String s, String t) {  // n, this is a copied version
        if(s.length() < t.length())
            return "";

        int[] hash = new int[256];

        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();

        for(char c:cht)
            hash[c]++;

        int[] res = new int[2];

        int lo = 0, hi = 0, count = cht.length, minLen = Integer.MAX_VALUE;

        while(hi < chs.length){
            char c = chs[hi];

            if(hash[c] >= 1)
                count--;

            hash[c]--;
            hi++;

            while(count == 0){
                if((hi-lo) < minLen){
                    minLen = hi - lo;
                    res[0] = lo;
                    res[1] = hi;
                }

                char prev = chs[lo++];
                if(hash[prev]++  >= 0) count++;
            }
        }
        return s.substring(res[0],res[1]);
    }

    public static void main(String[] args) {
        //System.out.println(new Q076v2().minWindow("ADOBECODEBANC","ABC"));
        System.out.println(new Q076v2().minWindow("bba","ab"));
    }
}
