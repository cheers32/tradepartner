package Q050_Q099;

public class Q074v2 { // overall, this 2-binary search approach is not correct
    // wiggle sort should be dfs approach, nth wiggle should be bfs
    public boolean searchMatrix(int[][] matrix, int target) {  // this full search is a good method; log(m*n) == log(m)+log(n), a double binary search can be used on head of each row
        if(matrix==null || matrix.length==0) {
            return false;
        }
        int start = 0;
        int end = matrix.length-1;
        while(start<end) {  // it should be <, not <=
            int mid = (start + end) / 2;
            int midVal = matrix[mid][matrix[0].length - 1];  // search the tail is the critical part
            if (midVal == target)
                return true;
            if (midVal < target)
                start = mid + 1;
            else
                end = mid;  // this end must stay hold, because the value could be in this row, so only updating start
        }
        // note that if the next row is not strictly greater than the previous row, this binary search will not work
        // must find first row with greater end and last row with smaller start, then search for it one by one
        // then how to do it?
        int firstGreaterEndRow = start;
        start = 0;
        end = matrix.length-1;
        while(start<end) {  // must be < if only one side is advancing
            int mid = (start + end) / 2;
            int midVal = matrix[mid][0];  // search the tail is the critical part
            if (midVal == target)
                return true;
            if (midVal < target)
                start = mid+1;  // this must be a standard style, only advancing lower end
            else
                end = mid;  // this end must stay hold, because the value could be in this row, so only updating start
        }
        int firstGreaterStartRow = start;
        for(int i=firstGreaterEndRow; i<=firstGreaterStartRow; i++) {  // also include this last row, because it can be only the last but not greater
            start = 0;
            end = matrix[0].length-1;
            while(start<=end) {
                int mid = (start + end) / 2;
                int midVal = matrix[i][mid];
                if (midVal == target)
                    return true;
                if (midVal < target)
                    start = mid+1;
                else
                    end = mid-1;
            }
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        //int[][] input = new int[][]{{0,1,2,4},{1,3,5,7},{4,6,8,10},{7,7,10,12}};
        int[][] input = new int[][]{{1,3,5,7},{4,6,8,10},{7,9,10,12}};
        System.out.println(new Q074v2().searchMatrix(input, 8));
    }
}
