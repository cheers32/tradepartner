package Q100_Q149;

public class Q123 {
    public int maxProfit(int[] prices) { // N, very important solution
        if(prices==null || prices.length==0)
            return 0;
        int low1 = prices[0];
        int profit1 = 0;
        int low2 = prices[0];
        int profit2 = 0;

        for(int i=1; i<prices.length; i++) {
            int price = prices[i];
            low1 = Math.min(low1, price);
            profit1 = Math.max(profit1, price-low1);
            low2 = Math.min(price-profit1, low2);
            profit2 = Math.max(profit2, price-low2);
        }
        return profit2;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,5,6,5,7};
        //System.out.println(new Q123().maxProfit(input));
        System.out.println(new Q123().maxProfit(input));
    }
}
