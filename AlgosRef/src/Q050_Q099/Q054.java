package Q050_Q099;

import java.util.LinkedList;
import java.util.List;

public class Q054 {
    public List<Integer> spiralOrder(int[][] matrix) {  // m*n
        List<Integer> res = new LinkedList<>();
        if(matrix==null || matrix.length==0)
            return res;
        int n = matrix.length;
        int m = matrix[0].length;
        int up=0;
        int down=n;
        int left=0;
        int right=m;
        //hile(res.size()<n*m) {  // this this condition in while is good
        int dir = 1;
        while(left<right && up<down) {  // my standard solution is ok
            if(dir==1) {
                for(int j=left; j<right; j++) {
                    res.add(matrix[up][j]);
                }
                up++;
                dir=2;
            } else if(dir==2) {
                for(int i=up; i<down; i++) {
                    res.add(matrix[i][right-1]);
                }
                right--;
                dir=3;
            } else if(dir==3) {
                for (int j = right-1; j >= left; j--) {
                    res.add(matrix[down-1][j]);
                }
                down--;
                dir = 4;
            } else if(dir==4) {
                for(int i=down-1; i>=up; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
                dir = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new Q054().spiralOrder(m));
    }
}
