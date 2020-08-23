package Q200_Q249;

import java.util.HashMap;
import java.util.Map;

public class Q221 {
    public int maximalSquare(char[][] matrix) {  // 这种题就是注意3个方向, 只有三个方向统一（最小值）才有可能下一个加一，最大还是最小,+1还是-1,从上到小从左到右单独的计数一般没用，累计还是单格，每一个值要有意义，多用例子推一下;
        // 我之前面试的那个题其实就是一个简单的2D DP，应该能够做的更好
        if(matrix==null || matrix.length==0)
            return 0;
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]=='0')
                    continue;
//                int left = j==0? 0 : matrix[i][j-1];
//                int up = i==0? 0 : matrix[i-1][j];
//                int upLeft = i==0 && j==0? 0 : matrix[i-1][j-1];
                int left = map.getOrDefault(i+"_"+(j-1),0);
                int up = map.getOrDefault(i-1+"_"+j,0);
                int upLeft = map.getOrDefault(i-1+"_"+(j-1),0);
                int cur = Math.min(Math.min(left, up), upLeft)+1;
                max = Math.max(cur, max);
                map.put(i+"_"+j, cur);
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        char[][] input = new char[][] {{'0','0','0','0'},{'1','1','1','0'},{'0','1','1','1'},{'1','1','1','1'}};
        System.out.println(new Q221().maximalSquare(input));
    }
}
