package Q050_Q099;

public class Q072 {
    public int minDistance(String word1, String word2) {  // very important 2d DP, m*n time; key is to find out operation's meaning on matrix
        int m = word1.length();
        int n = word2.length();
        if(m==0 || n==0) {
            return Math.max(m, n);  // special case for empty
        }
        int[][] dp = new int[m+1][n+1];  // extra large
        // init dp first row and column
        for(int i=0; i<=m; i++)
            dp[i][0]=i;
        for(int j=0; j<=n; j++)
            dp[0][j]=j;

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                int left = dp[i][j-1]; // insert
                int topleft = dp[i-1][j-1];  // replace
                int top = dp[i-1][j]; // delete
                int min = Math.min(left, Math.min(top, topleft));
                if(word1.charAt(i-1)==word2.charAt(j-1)) {  // same char
                    dp[i][j] = topleft;
                } else {
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[m][n];
    }
}
