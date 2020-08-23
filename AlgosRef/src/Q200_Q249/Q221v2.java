package Q200_Q249;

import java.util.HashMap;
import java.util.Map;

public class Q221v2 {
    public int maximalSquare(char[][] matrix) {  // M*N, this version uses a dp 2d array instead of map; 我曾经的做法是一个m^2n^2的brute force做法; similarly, my chip wafer problem should be solved this way; 我觉得一般不应该是一个ranged sum,而就是对这个点的纪录
        if(matrix==null || matrix.length==0)
            return 0;
        int[][] dp = new int[matrix.length][matrix[0].length]; // since i'm handling edge condition, it's ok to create same size
        int max = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]=='0')
                    continue;
                int left = j==0? 0 : dp[i][j-1];  // update only when current value is 1
                int up = i==0? 0 : dp[i-1][j];
                int upLeft = i==0 || j==0? 0 : dp[i-1][j-1];  // note this is "or" condition for diagonal
                int cur = Math.min(Math.min(left, up), upLeft)+1;
                max = Math.max(cur, max);
                dp[i][j] = cur;
            }
        }
        return max*max;  // this could be size, diameter, side etc.
    }

    public static void main(String[] args) {
        char[][] input = new char[][] {{'0','0','0','0'},{'1','1','1','0'},{'0','1','1','1'},{'1','1','1','1'}};
        System.out.println(new Q221v2().maximalSquare(input));
    }
}
