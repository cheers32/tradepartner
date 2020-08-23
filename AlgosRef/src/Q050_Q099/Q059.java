package Q050_Q099;

public class Q059 {
    public int[][] generateMatrix(int n) {  // N^2, very good solution, no extra handling
        int[][] res = new int[n][n];
        int up=0;
        int down=n;
        int left=0;
        int right=n;
        int num = 1;
        while(left<right && up<down) {  // check condition in while loop too
            for(int j=left; j<right && up<down; j++) {  // every step needs to check all boundary condition
                res[up][j] = num;
                num++;
            }
            up++;
            for(int i=up; i<down && left<right; i++) {
                res[i][right-1] = num;
                num++;
            }
            right--;
            for (int j = right-1; j >= left && up<down; j--) {
                res[down-1][j] = num;
                num++;
            }
            down--;
            for(int i=down-1; i>=up && left<right; i--) {
                res[i][left] = num;
                num++;
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q059().generateMatrix(4));

    }
}
