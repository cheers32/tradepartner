package Q001_Q049;

public class Q028 {
    public int strStr(String haystack, String needle) {  // n*k
        if(needle == null || needle.length()==0)  // this is success condition
            return 0;
        int count=0;
        for(int i=0; i<haystack.length(); i++) {
            if(haystack.charAt(i)==needle.charAt(count)) {
                count++;
                if(count==needle.length()) {
                    return i-count+1;
                }
            } else {
                i=i-count; // this i also needs to go back;  this step must do first
                count = 0;
            }
        }
        return -1;
    }
}
