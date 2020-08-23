package Q050_Q099;

public class Q063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid[0].length == 0)
            return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        if(obstacleGrid[0][0]!=1)  // notice this init condition check to make first cell as 1
            dp[0][0] = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i==0 && j==0)
                    continue;
                if(obstacleGrid[i][j]==1) {  // set as 0 for obstacle is correct
                    dp[i][j]=0;
                }
                else {
                    int upPath = i == 0 ? 0 : dp[i - 1][j];
                    int leftPath = j == 0 ? 0 : dp[i][j - 1];
                    dp[i][j] = upPath + leftPath;
                }
            }
        }
        return dp[n-1][m-1];
    }
}
