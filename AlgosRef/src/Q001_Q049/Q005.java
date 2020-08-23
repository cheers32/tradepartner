package Q001_Q049;

public class Q005 {
    public String longestPalindrome(String s) {  // n^2
        if(s==null || s.length()==0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++) {
           int len1 = expand(s, i, i);  // expand to left and right
           int len2 = expand(s, i, i+1);
           int len = Math.max(len1, len2);
           if(len>end-start+1) {  // this is just normal len comparison (+1 is ok)
               start = i-(len-1)/2;  // from current i to left (half len), len-1 is just an adjustment
               end = i+(len/2); // from cuurent i to right (half len)
           }
        }
        return s.substring(start, end+1); // use end+1 for substring, because end index is not included
    }

    private int expand(String s, int l, int r) {
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
            l--;
            r++;
        }
        return r-l-1;  // this is -1 for "accb", "xacay"
    }

    public static void main(String[] args) {
        Q005 q = new Q005();
        System.out.println(q.longestPalindrome("abba"));
    }
}
