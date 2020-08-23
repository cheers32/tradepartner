package Q250_299;

import java.util.Arrays;

public class Q274 {
    public int getHIndex(int[] citations){  // N time, passed at first time
        if(citations == null)
            return 0;
        //Arrays.sort(citations);
        //int hCand = citations.length;
        int[] dp = new int[citations.length+1];
        for(int v : citations) {   // no need to sort, just do a stats
            if(v>citations.length) {
                dp[citations.length]+=1;
            } else {
                dp[v]+=1;
            }
        }
        int sum = 0;
        for(int i=dp.length-1; i>=0; i--) {  // this is important part, just pass down the result to lower h candidate with range sum
            sum+=dp[i];
            if(sum>=i)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        new Q274().getHIndex(new int[] {2,5,5,6,8});
    }
}
