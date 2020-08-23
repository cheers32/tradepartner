package Q050_Q099;

import java.util.ArrayList;
import java.util.List;

public class Q078 {
    public List<List<Integer>> subsets(int[] nums) {  // n!, N*2^N, space is 2^N
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int n : nums) {
            int size = res.size();  // record a size
            for(int i=0; i<size; i++) {
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(n);
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,2,3};
        List<List<Integer>> res = new Q078().subsets(input);
        System.out.println(res);
    }
}
