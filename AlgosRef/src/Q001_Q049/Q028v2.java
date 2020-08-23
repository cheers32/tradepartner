package Q001_Q049;

public class Q028v2 {
    public int strStr(String haystack, String needle) {  // n*k, this standard double loop approach is better
        if(needle == null || needle.length()==0)  // this is success condition
            return 0;
        for(int i=0; i<=haystack.length()-needle.length(); i++) { // note this <=n-k location
            boolean isFound = true;
            for(int j=0; j<needle.length(); j++) {
                if(haystack.charAt(i+j)!=needle.charAt(j)) { // note this i+j location
                    isFound = false;
                    break;
                }
            }
            if(isFound)
                return i;
        }
        return -1;
    }
}
