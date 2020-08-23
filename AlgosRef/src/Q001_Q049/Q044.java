package Q001_Q049;

public class Q044 {
    public boolean isMatch(String s, String p) {  // m*n, very good solution
        if(s==null || p==null)
            return false;
        int n = p.length();
        int m = s.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;  // init case 1, top left as true
//        for(int j=1; j<=m; j++)
//            dp[0][j] = false;
        for(int i=1; i<=n; i++)  // init case 2, for stars at front
            if(p.charAt(i-1)=='*')
                dp[i][0]=true;
            else
                break; // cut to break
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(p.charAt(i-1)=='*') {  // star case
                    if(dp[i-1][j] || dp[i][j-1])
                        dp[i][j]=true;
                }
                else {
                    if(dp[i-1][j-1] && (p.charAt(i-1)==s.charAt(j-1)  // normal case
                            ||p.charAt(i-1)=='?'))  // this question mark is a simple case
                        dp[i][j]=true;  // up True case means star to ignore future ones; left True case means star can represent before this
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        //System.out.println(new Q001_Q049.Q044().isMatch("abc","a*c"));
        //System.out.println(new Q001_Q049.Q044().isMatch("aa","a"));
        System.out.println(new Q044().isMatch("adceb","*a*b"));
    }
}
