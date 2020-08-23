package Q100_Q149;

import java.util.Arrays;

public class Q123v2 {
    public int maxProfitForK(int[] prices, int k) {  // N*k, make this K time trading worked! it's very important to draw logic on paper and then implement
        if(prices == null || prices.length == 0)
            return 0;
        int[] low = new int[k];
        int[] profit = new int[k];
        Arrays.fill(low, prices[0]);
        for(int i=0; i<prices.length; i++) {
            int price = prices[i];
            for(int j=0; j<k; j++) {
                if(j==0) {
                    low[j] = Math.min(low[j], price);  // this has no substraction
                } else {
                    low[j] = Math.min(low[j], price-profit[j-1]);
                }
                profit[j] = Math.max(profit[j], price-low[j]);  // this is same for i==0 and i>0
            }
        }
        return profit[k-1];
    }

    public int maxProfitForK_Wrong(int[] prices, int k) {  // this is wrong
        if(prices == null || prices.length == 0)
            return 0;
        int low = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++) {
            int price = prices[i];
            for(int j=0; j<k; j++) {
                low = Math.min(low, price-profit);
                profit = Math.max(profit, price-low);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        //int[] input = new int[]{2,5,6,5,7};
        //System.out.println(new Q123v2().maxProfitForK(input,1));
        int[] input = new int[]{0,2,5,6,5,7};
        System.out.println(new Q123v2().maxProfitForK(input,3));
    }
}
