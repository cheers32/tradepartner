package Q200_Q249;

public class Q240 {
    public boolean searchMatrix(int[][] matrix, int target) { // M+N, very straightforward solution, passed first time
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        int i = 0;
        int j = matrix[0].length-1;
        while(i<matrix.length && j>=0) { // didn't write it correct first time at this loop, should use while with 2 conditions, not 2 for loops
            int val = matrix[i][j];
            if(val==target)
                return true;
            else if(val>target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
