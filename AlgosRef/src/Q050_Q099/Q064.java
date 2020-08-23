package Q050_Q099;

public class Q064 {
    public int minPathSum(int[][] grid) {  // m*n, easy solution, don't forget to set init value at first cell
        if(grid==null || grid[0].length==0)
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m]; // does this dp have to be a 2d array?
        dp[0][0] = grid[0][0];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i==0 && j==0)
                    continue;
                int up = i==0? Integer.MAX_VALUE : dp[i-1][j];
                int left = j==0? Integer.MAX_VALUE : dp[i][j-1];
                dp[i][j] = Math.min(up, left)+grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new Q064().minPathSum(input));
    }
}
