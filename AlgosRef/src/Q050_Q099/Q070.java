package Q050_Q099;

public class Q070 {  // very simple, n
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int fromOneBack = 2;
        int fromTwoBack = 1;
        int res = 0;
        for(int i=3; i<=n; i++) {
            res = fromOneBack+fromTwoBack;
            fromTwoBack = fromOneBack;
            fromOneBack = res;
        }
        return res;
    }
}
