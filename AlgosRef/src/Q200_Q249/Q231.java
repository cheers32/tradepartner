package Q200_Q249;

public class Q231 {
    public boolean isPowerOfTwo(int n) { // logN, 数学问题，不考虑bit的做法
        while(n/2>0 && n%2==0) {  // 能整除时整除,退出后判断是否为1
            n/=2;
        }
        if(n==1)
            return true;
        else
            return false;
    }
}
