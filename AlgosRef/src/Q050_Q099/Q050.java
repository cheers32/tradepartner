package Q050_Q099;

public class Q050 {
    public double myPow(double x, int n) { // binary search, log(n)
        if(n==0 || x==1)  // useful special case
            return 1d;
        if(Math.abs(x)!=1 && n==Integer.MIN_VALUE) // not very useful case
            return 0d;
        if(n<0) {
            n=-n;
            x=1/x;
        }
        if(n%2==0) {
            return myPow(x*x, n/2);
        } else {
            return x * myPow(x*x, n/2);  // easy and important case
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q050().myPow(2, 5));
        System.out.println(new Q050().myPow(2, 0));
        System.out.println(new Q050().myPow(-1, 6));
    }
}
