package Q050_Q099;

import java.util.LinkedList;
import java.util.List;

public class Q054v2 {
    public List<Integer> spiralOrder(int[][] matrix) {  // m*n, i like this v2 version better
        List<Integer> res = new LinkedList<>();
        if(matrix==null || matrix.length==0)
            return res;
        int n = matrix.length;
        int m = matrix[0].length;
        int up=0;
        int down=n;
        int left=0;
        int right=m;
        //while(res.size()<n*m) {  // this this condition in while is good
        while(left<right && up<down) {  // check condition in while loop too
            for(int j=left; j<right && up<down; j++) {  // every step needs to check all boundary condition
                res.add(matrix[up][j]);
            }
            up++;
            for(int i=up; i<down && left<right; i++) {
                res.add(matrix[i][right-1]);
            }
            right--;
            for (int j = right-1; j >= left && up<down; j--) {
                res.add(matrix[down-1][j]);
            }
            down--;
            for(int i=down-1; i>=up && left<right; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new Q054v2().spiralOrder(m));
    }
}
