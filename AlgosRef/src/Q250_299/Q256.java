package Q250_299;

public class Q256 {
    public int minCost(int[][] costs) {  // 基本上一次性过了，　N*m*m时间
        if(costs == null || costs.length==0) // corrected: 这里没有考虑到空集的情况，只考虑了ｎ＝１的情况，这样会导致最后统计时出错
            return 0;
        for(int i=1; i<costs.length; i++) {
            for(int j=0; j<3; j++) {
                int min = Integer.MAX_VALUE;
                for(int k = 0; k<3; k++) {
                    if(k==j)
                        continue;
                    min = Math.min(min, costs[i-1][k]);
                }
                costs[i][j] += min;
            }
        }
        int res = Integer.MAX_VALUE; // 最后从最后一行收集结果
        for(int k=0; k<3; k++) {
            res = Math.min(res, costs[costs.length-1][k]);
        }
        return res;
    }
}
