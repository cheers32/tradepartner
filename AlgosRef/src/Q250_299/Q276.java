package Q250_299;

public class Q276 {
    public int numWays(int n, int k) {  // N, 这个题目虽然是简单题,但这个递推过程非常重要,一定要非常熟练；注意这个不能推广到三个房子或以上
        if(n==0)
            return 0;
        if(n==1)
            return k;
        int sameCnt = k;
        int diffCnt = k*(k-1);  // 这个初始条件非常重要，这是从第二个房子开始的

        for(int i=2; i<n; i++) {
            int temp = sameCnt;
            sameCnt = diffCnt;
            diffCnt = (k-1)*temp + (k-1)*diffCnt;
        }
        return sameCnt+diffCnt;
    }

    public static void main(String[] args) {
        System.out.println(new Q276().numWays(2,2));
    }
}
