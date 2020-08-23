package Q100_Q149;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q120v2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] arr = new int[n+1][n+1];
        for(int i = n-1;i>=0;i--){
            // for(int j = 0;j<=i;j++){
            for(int j = 0;j<triangle.get(i).size();j++){  // i prefer this iteration
                arr[i][j] = Math.min(arr[i+1][j],arr[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return arr[0][0];
    }

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(2);
        List<Integer> l2 = Arrays.asList(3,4);
        List<Integer> l3 = Arrays.asList(6,5,7);
        List<Integer> l4 = Arrays.asList(4,1,8,3);
        List<List<Integer>> input = new ArrayList<>();
        input.add(l1);input.add(l2);input.add(l3);input.add(l4);
        System.out.println(new Q120v2().minimumTotal(input));
    }
}
