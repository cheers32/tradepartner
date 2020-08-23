package Q250_299;

public class Q278 {
    public int firstBadVersion(int n) {  // logN, good binary search problem
        int s = 1;
        int e = n;
        while(s<=e) {
            //int mid = (s+e)/2;
            int mid = s+(e-s)/2;  // corrected: this problem uses a large number, so need to handle this way, s+ (e-s)/2
            if(isBadVersion(mid))
                e = mid-1;  // important: here must be mid-1, cannot return, cannot stay on this, thinking about s==e situation
            else
                s = mid+1;  // mid is confirmed not bad, so s go to mid+1; if no bad version, this will be n+1
        }
        return s;  // because mid-1 on bad version if s==e, then return s is correct
    }

    boolean isBadVersion(int version) {
        return false;
    }
}
