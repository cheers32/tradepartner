package Q150_Q199;

import ds.ArrayUtil;

public class Q161 {

    public boolean isOneEditDistance(String s, String t) {  //　m*n 这个题最后终于过了，我觉得这个题我的做法挺好的，但好几个地方想的不对
        // 首先，初始化两个边界行可以有效改正corner case；第二，并不是选一个最小值，而是增删时加一；只在左上时递增；说我必须要推出逻辑，而不是硬套
        if(s==null || t==null)
            return false;
        int[][] dp = new int[s.length()+1][t.length()+1];  // use +1 because need to handle empty string case
        for(int i=0; i<dp.length; i++) {  // this initialization is important, observed by making examples on paper
            dp[i][0] = i;
        }
        for(int j=0; j<dp[0].length; j++) {
            dp[0][j] = j;
        }
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                int left = dp[i][j-1]+1;
                int up = dp[i-1][j]+1;
                int upLeft = s.charAt(i-1)==t.charAt(j-1) ? dp[i-1][j-1] : dp[i-1][j-1]+1;
                dp[i][j] = Math.min(left, Math.min(up, upLeft));
            }
        }
        ArrayUtil.print2DArray(dp);
        return dp[dp.length-1][dp[0].length-1]==1;
    }

//    public boolean isOneEditDistance(String s, String t) {
//        if(s==null || t==null)
//            return false;
//        int[][] dp = new int[s.length()+1][t.length()+1];  // use +1 because need to handle empty string case
//        for(int i=0; i<s.length(); i++) {
//            for(int j=0; j<t.length(); j++) {
//                int left = j>0 ? dp[i][j-1] : Integer.MAX_VALUE;
//                int up = i>0 ? dp[i-1][j] : Integer.MAX_VALUE;
//                int upLeft = i>0 && j>0 ? dp[i-1][j-1] : 0;
//                int min = Math.min(left, Math.min(up, upLeft));
//                dp[i][j] = s.charAt(i)==t.charAt(j) ? min : min+1;
//            }
//        }
//        return dp[s.length()-1][t.length()-1]<=1;
//    }

    public static void main(String[] args) {
        System.out.println(new Q161().isOneEditDistance("ac","acb"));
        //System.out.println(new Q161().isOneEditDistance("ac","adb"));
        //System.out.println(new Q161().isOneEditDistance("a",""));
        //System.out.println(new Q161().isOneEditDistance("a","aa"));
    }
}
