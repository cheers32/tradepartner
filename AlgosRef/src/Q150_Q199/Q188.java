package Q150_Q199;

import java.util.Arrays;

public class Q188 {
    public int maxProfit(int k, int[] prices) {  // k*n, this is my standard approach, but it said this exceeds timeout
        if(prices==null || prices.length==0)  // added length == 0 check, because my result is using the length
            return 0;

        // added trivial case for k>n/2 for optimization
        if(k>prices.length/2) {
            int res = 0;
            for(int i=1; i<prices.length; i++) {
                int diff = prices[i]-prices[i-1];
                if(diff>0)
                    res+=diff;
            }
            return res;
        }

        int[] minCost = new int[prices.length];
        int[] maxProfit = new int[prices.length];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        for(int i=0; i<k; i++) {  // loop k times on dp array
            for(int j=0; j<prices.length; j++) {
                int cost = prices[j] - maxProfit[j];
                minCost[j] = j>0? Math.min(minCost[j-1], cost):cost;
                int profit = prices[j]-minCost[j];
                maxProfit[j] = j>0? Math.max(profit, maxProfit[j-1]):profit;
            }
        }
        return maxProfit[prices.length-1];  // when using length as return, be mindful of the length check
    }

    public static void main(String[] args) {
        System.out.println(new Q188().maxProfit(2, new int[]{3,2,6,5,0,3}));
        System.out.println(new Q188().maxProfit(10, new int[]{1,2,3,1,5}));
    }
}
