package Q050_Q099;

import java.util.Stack;

public class Q085 {
    public int maximalRectangle(char[][] matrix) {  // very good N*M solution. this is an extension of the Q84 solution.
        if(matrix==null || matrix.length==0) {  // notice this is matrix.length, not matrix[0].length
            return 0;
        }
        int max = 0;
        int[] height = new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]=='1')  // this condition is considered to be range sum or dp solution.
                    height[j] += 1;
                else
                    height[j] = 0;
            }
            int curMax = getMaxArea(height);  // gather height for every row, then do the max rectangle calculation
            max = Math.max(max, curMax);
        }
        return max;
    }

    int getMaxArea(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        Stack<Integer> idxStack = new Stack<>(); // index
        int max = 0;
        idxStack.push(0);
        for(int i=1; i<height.length; i++) {
            if(height[i]>=height[idxStack.peek()])  // make it >=, so that to solve back tracking problem for correct idx
                idxStack.push(i);
            else {
                while(!idxStack.isEmpty() && height[i]<height[idxStack.peek()]) {
                    int topIdx = idxStack.pop();
                    int prevIdx = idxStack.isEmpty() ? -1 : idxStack.peek();
                    int area = (i-prevIdx-1) * height[topIdx];
                    max = Math.max(max, area);
                }
                idxStack.push(i);
            }
        }
        while(!idxStack.isEmpty()) {
            int topIdx = idxStack.pop();
            int prevIdx = idxStack.isEmpty() ? -1 : idxStack.peek();
            int area = (height.length-prevIdx-1) * height[topIdx];
            max = Math.max(max, area);
        }
        return max;
    }

    Q084 algo = new Q084();

    public static void main(String[] args) {
        char[][] matrix = new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int res = new Q085().maximalRectangle(matrix);
        System.out.println(res);

        int[] height = new int[]{2,0,2,1,1};
        new Q085().getMaxArea(height);
    }
}
