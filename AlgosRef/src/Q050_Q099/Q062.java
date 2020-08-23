package Q050_Q099;

public class Q062 {
    public int uniquePath(int m, int n) {  // m*n, very standard 2d array solution
        int[][] dp = new int[n][m];
        dp[0][0] = 1;  // init dp
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i==0 && j==0)
                    continue;
                int upPath = i==0?0:dp[i-1][j];
                int leftPath = j==0?0:dp[i][j-1];
                dp[i][j] = upPath + leftPath;
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        System.out.println(new Q062().uniquePath(2,2));
    }
}
