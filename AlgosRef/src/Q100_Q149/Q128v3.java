package Q100_Q149;

import java.util.HashSet;
import java.util.Set;

public class Q128v3 {
    public int longestConsecutive(int[] nums) { // this is just one direction simple counting
        Set<Integer> set = new HashSet<>();
        for(int n : nums)
            set.add(n);
        int max = 0;
        for(int n : set) {
            if(set.contains(n-1))
                continue;
            int m = n+1;
            while(set.contains(m)) {
                m++;
            }
            int len = m-n;
            max = Math.max(max, len);
        }
        return max;
    }
}
