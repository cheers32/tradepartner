package Q050_Q099;

public class Q073 {
    public void setZeros(int[][] matrix) {   // m*n, with optimization of using O(1) space
        if(matrix==null || matrix[0].length==0)
            return;
        int n = matrix.length;
        int m = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j]==0) {
                    if(i==0)
                        firstRow = true;  // use first row and first column to note whether first row has actual 0
                    if(j==0)
                        firstCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i=1; i<n; i++) {  // start from 2nd row
            if(matrix[i][0]==0) {
                for(int j=0; j<m; j++)
                    matrix[i][j]=0;
            }
        }
        for(int j=1; j<m; j++) {  // start from 2nd col
            if(matrix[0][j]==0) {
                for(int i=0; i<n; i++)
                    matrix[i][j]=0;
            }
        }
        if(firstRow) {
            for(int j=0; j<m; j++) {
                matrix[0][j]=0;
            }
        }
        if(firstCol) {
            for(int i=0; i<n; i++) {
                matrix[i][0]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new Q073().setZeros(matrix);
        System.out.println(matrix);
    }
}
