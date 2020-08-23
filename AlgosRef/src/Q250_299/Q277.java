package Q250_299;

public class Q277 {
    public int findCelebrity(int n) {  // N, 重要题目,与求众数类似
        int cand = 0;
        for(int i=1; i<n; i++) {
            if(knows(cand, i)) {
                cand = i;
            }
        }
        for(int i=0; i<n; i++) {
            if(cand == i)
                continue;
            if(knows(cand, i) || !knows(i, cand))  // corrected: 居然少了这么一个条件,真是没有想到,在验证过程中需要双向验证,一定要注意
                return -1;
        }
        return cand;
    }

    boolean knows(int a, int b) {
        return false;
    }
}
