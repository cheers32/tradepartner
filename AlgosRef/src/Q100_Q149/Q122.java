package Q100_Q149;

public class Q122 {
    public int maxProfit(int[] prices) {  // N, trivial problem!
        if(prices==null || prices.length==0)
            return 0;
        int res = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i]>prices[i-1])
                res += prices[i]-prices[i-1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,4,5,3,6,4};
        System.out.println(new Q122().maxProfit(input));
    }
}
