package Q050_Q099;

public class Q074 {
    public boolean searchMatrix(int[][] matrix, int target) {  // this full search is a good method; log(m*n) == log(m)+log(n), a double binary search can be used on head of each row
        if(matrix==null || matrix.length==0) {
            return false;
        }
        int start = 0;
        int end = matrix.length * matrix[0].length-1;
        while(start<=end) {
            int mid = (start+end)/2;
            int row = mid/matrix[0].length;  // both are on column
            int col = mid%matrix[0].length;
            int midVal = matrix[row][col];
            if(midVal == target)
                return true;
            if(midVal<target)
                start = mid+1;
            else
                end = mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(new Q074().searchMatrix(input, 3));
    }
}
