package Q100_Q149;

public class Q121 {
    public int maxProfit(int[] prices) {  // N, no need for recursion
        if(prices == null)
            return 0;
        int max = 0;
        int curLow = Integer.MAX_VALUE;
        for(int p : prices) {
            curLow = Math.min(curLow, p);
            int profit = p-curLow;
            max = Math.max(profit, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(new Q121().maxProfit(prices));
    }
}
