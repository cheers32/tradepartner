package Q050_Q099;

public class Q069 {
    public int mySqrt(int x) {  // log(x)
        if(x<=0)
            return 0;
        if(x==1)   // must handle 0 and 1 case separately
            return 1;
        int left = 0;
        int right = x/2;  // start with half of x
        while(left <= right) {  // normal <= comparison
            int mid = (left+right)/2;
            double square = Math.pow(mid, 2);  // this must use pow to make it working
            if(square == x)
                return mid;
            else if(square < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;  // return right by testing
    }

    public static void main(String[] args) {
        System.out.println(new Q069().mySqrt(8));
    }

    public int mySqrt_v2(int x) { // this method has adjustment, maybe not as good as original one
        if(x==0)
            return 0;
        int left = 1;
        int right = x/2+1;
        while(left<right-1) {
            int mid = (left+right)/2;
            double midVal = Math.pow(mid, 2);
            if(midVal == x)
                return mid;
            else if(midVal > x) {
                right = mid;
            } else
                left = mid;
        }
        return left;
    }
}
