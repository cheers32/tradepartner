package Q100_Q149;

import java.util.Arrays;
import java.util.List;

public class Q0119v2 { // this is not an intuitive solution
    public List<Integer> getRow(int rowIndex) { // this problem can be done using same approach as q118
        Integer[] res = new Integer[rowIndex+1]; // this is a new solution still with N^2 time
        Arrays.fill(res, 0);
        res[0]=1;
        for(int i=1; i<=rowIndex; i++) {
            for(int j=i; j>=1; j--)
                res[j]+=res[j-1];
        }
        return Arrays.asList(res);
    }

    public static void main(String[] args) {
        //System.out.println(new Q0119v2().getRow(0));
        //System.out.println(new Q0119v2().getRow(1));
        System.out.println(new Q0119v2().getRow(2));
    }
}
