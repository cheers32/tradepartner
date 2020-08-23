package Q250_299;

public class Q264copy {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int idx2=0, idx3=0, idx5=0;
        int count=1;  //1 is also ugly number, we're starting with 2
        int res=0;
        int[] multipliers = new int[n];
        multipliers[0]=1;
        int idx=1;
        while(count<n){
            int num2=2*multipliers[idx2];
            int num3=3*multipliers[idx3];
            int num5=5*multipliers[idx5];
            int ugly = Math.min(Math.min(num2,num3),num5);
            count++;
            if(ugly==num2)  // 这种做法，由于不是 else if, 所以符合条件的都会进位，从而避免了重复
                idx2++;
            if(ugly==num3)
                idx3++;
            if(ugly==num5)
                idx5++;
            multipliers[idx]=ugly;
            idx++;
            if(count==n)
                res=ugly;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q264copy().nthUglyNumber(7));
    }
}
