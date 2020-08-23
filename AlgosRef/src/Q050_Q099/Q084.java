package Q050_Q099;

public class Q084 {  // this is a brute force N^2 solution
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }
        int res = 0;
        for(int i=0; i<heights.length; i++) {
            int minH = heights[i];
            for(int j=i; j<heights.length; j++) {
                int width = j-i+1;
                minH = Math.min(minH, heights[j]);
                int area = minH * width;
                res = Math.max(area, res);
            }
        }
        return res;
    }
}
