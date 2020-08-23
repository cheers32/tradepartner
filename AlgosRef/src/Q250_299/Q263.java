package Q250_299;

public class Q263 {
    public boolean isUglyNumber(int num) { // N, simple math problem
        //int n = Math.abs(num);  looks like negative numbers are all invalid
        int n = num;
        while(n>1) {
            if(n%5==0) {
                n /= 5;
            }
            else if(n%3==0) {
                n /= 3;
            }
            else if(n%2==0) {
                n /= 2;
            } else {  // corrected: must add this exit condition for non-qualified n; i used all "if", and thought n would exit, should run actual test cases to find out
                break;  // no need to return false here, just let last step to decide
            }
        }
        return n == 1;
    }
}
