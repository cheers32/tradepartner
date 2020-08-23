package Q150_Q199;

public class Q159v3 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {  // N, this approach uses two pointers; this is a good solution; no need to record actual letters
        if(s==null || s.length()==0)
            return 0;
        int c1Idx = -1;
        int c2Idx = -1;
        int max = 0;
        int len = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c1Idx==-1 || c==s.charAt(c1Idx)) {  // continuously update index
                c1Idx = i;
                len++;  // this increasement is not easy to write out
                //len = c1Idx<c2Idx ? i-c1Idx+1 : i-c2Idx+1;  // this doesn't work, has to increase len
            } else if(c2Idx==-1 || c==s.charAt(c2Idx)) {
                c2Idx = i;
                len++;
                //len = c1Idx<c2Idx ? i-c1Idx+1 : i-c2Idx+1;
            } else {
                //len = c1Idx<c2Idx ? i-c1Idx : i-c2Idx;
                if (c1Idx < c2Idx) {
                    len = i-c1Idx;
                    c1Idx = i;
                } else {
                    len = i-c2Idx;
                    c2Idx = i;
                }
            }
            max = Math.max(max, len);
        }
        return max;
    }

    public int lengthOfLongestSubstringTwoDistinct_wrong(String s) {  // 2*N*k, this approach records 2 chars, but doesn't work
        if(s==null || s.length()==0)
            return 0;
        char c1 = '0';
        char c2 = '0';
        int c1Idx = 0;
        int c2Idx = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c1=='0') {
                c1 = c;
                c1Idx = i;
            } else if(c!=c1 && c2=='0') {
                c2 = c;
                c2Idx = i;
            } else if(c!=c1 && c!=c2) {  // this switching does not work
                c1 = c2;
                c2 = c;
                c1Idx = c2Idx;
                c2Idx = i;
            }
            int len = i-c1Idx+1;
            max = Math.max(max, len);
        }
        return max;
    }

    public static void main(String[] args) {
        //System.out.println(new Q159v3().lengthOfLongestSubstringTwoDistinct("abaccc"));
        //System.out.println(new Q159v3().lengthOfLongestSubstringTwoDistinct("aac"));
        System.out.println(new Q159v3().lengthOfLongestSubstringTwoDistinct("eceba"));
        //System.out.println(new Q159v3().lengthOfLongestSubstringTwoDistinct("bacc"));
    }
}
