package Q001_Q049;

public class Q011 {
    public int maxArea(int[] height) {  // n
        if(height == null || height.length < 2)
            return 0;
        int res = 0;
        int s = 0;
        int e = height.length-1;
        while(s < e) {
            int left = height[s];
            int right = height[e];
            int area = (e-s)*Math.min(left,right);
            if(area>res) {
                res = area;
            }
            if(left<right) {
                s++;
            } else {
                e--;
            }
        }
        return res;
    }
}
