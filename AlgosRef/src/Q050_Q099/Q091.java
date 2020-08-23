package Q050_Q099;

public class Q091 {  /// also similar to the subsequence problem, very important problem
    public int numDecodings(String s) {  // this is a fibonacci advancing dp N
        if(s==null || s.isEmpty() || s.charAt(0)=='0')
            return 0;
        int res = 0;
        int resMinus1 = 0;  // this is the actual dp, both can init as 1, and then no need to check i later
        int resMinus2 = 0;
        for(int i=0; i<s.length(); i++) {
            int takeOneRes = 0;  // this is the temp count
            int takeTwoRes = 0;
            // 1 digit
            int single = s.charAt(i)-'0';
            if(single >=1 && single <=9)  // check whether 1-digit is valid
                takeOneRes = i>0 ? resMinus1 : 1;  // take dp[i-1] result
            // 2 digits
            if(i>0) {
                int tenth = s.charAt(i-1)-'0';
                int takeTwoVal = tenth*10+single;
                if(takeTwoVal>=10 && takeTwoVal<=26) {  // check whether 2-digit is valid
                    takeTwoRes = i>1? resMinus2 :1;  // important, take dp[i-2] result
                }
            }
            res = takeOneRes + takeTwoRes;
            resMinus2 = resMinus1;
            resMinus1 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q091().numDecodings("125"));
        System.out.println(new Q091().numDecodings("12"));
        System.out.println(new Q091().numDecodings("0"));
        System.out.println(new Q091().numDecodings("10"));
        System.out.println(new Q091().numDecodings("01"));
        System.out.println(new Q091().numDecodings(""));
        System.out.println(new Q091().numDecodings("100"));
        System.out.println(new Q091().numDecodings("101"));

    }
}
